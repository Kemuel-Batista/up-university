from flask import Blueprint, jsonify, request
from .models import Lancamento
from .extensions import db, cache
from datetime import datetime
import json

bp = Blueprint('main', __name__)

@bp.route('/lancamentos', methods=['POST'])
def criar_lancamento():
    data = request.get_json()
    
    # Validação básica
    required_fields = ['descricao', 'valor', 'categoria']
    if not all(field in data for field in required_fields):
        return jsonify({'error': 'Campos obrigatórios faltando'}), 400
    
    try:
        lancamento = Lancamento(
            descricao=data['descricao'],
            valor=data['valor'],
            data=datetime.strptime(data.get('data', datetime.utcnow().isoformat()), '%Y-%m-%d').date(),
            categoria=data['categoria']
        )
        
        db.session.add(lancamento)
        db.session.commit()
        
        # Invalida cache
        cache.delete('all_lancamentos')
        
        return jsonify(lancamento.to_dict()), 201
    except Exception as e:
        db.session.rollback()
        return jsonify({'error': str(e)}), 500

@bp.route('/lancamentos', methods=['GET'])
def listar_lancamentos():
    # Tenta pegar do cache primeiro
    cached_data = cache.get('all_lancamentos')
    if cached_data:
        return jsonify(json.loads(cached_data))
    
    lancamentos = Lancamento.query.all()
    result = [lanc.to_dict() for lanc in lancamentos]
    
    # Armazena no cache por 5 minutos (300 segundos)
    cache.set('all_lancamentos', json.dumps(result), ex=300)
    
    return jsonify(result)

@bp.route('/lancamentos/<int:id>', methods=['GET'])
def obter_lancamento(id):
    lancamento = Lancamento.query.get_or_404(id)
    return jsonify(lancamento.to_dict())

@bp.route('/lancamentos/<int:id>', methods=['DELETE'])
def deletar_lancamento(id):
    lancamento = Lancamento.query.get_or_404(id)
    
    db.session.delete(lancamento)
    db.session.commit()
    
    # Invalida cache
    cache.delete('all_lancamentos')
    
    return jsonify({'message': 'Lançamento deletado com sucesso'})

@bp.route('/healthcheck', methods=['GET'])
def healthcheck():
    try:
        # Testa conexão com PostgreSQL
        db.engine.execute('SELECT 1')
        
        # Testa conexão com Redis
        cache.ping()
        
        return jsonify({
            'status': 'healthy',
            'services': {
                'postgresql': 'ok',
                'redis': 'ok'
            }
        })
    except Exception as e:
        return jsonify({
            'status': 'unhealthy',
            'error': str(e)
        }), 500