from flask import Blueprint, jsonify, request
from .models import Lancamento
from .extensions import db, cache
import requests
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

    categoria_nome = data['categoria']

    # Verifica se a categoria existe via requisição GET
    try:
        categoria_response = requests.get(f'http://localhost:3003/categoria/{categoria_nome}')
        if categoria_response.status_code != 200:
            return jsonify({'error': f'Categoria "{categoria_nome}" não existe'}), 404
    except requests.RequestException as e:
        return jsonify({'error': 'Erro ao verificar categoria: ' + str(e)}), 500

    try:
        lancamento = Lancamento(
            descricao=data['descricao'],
            valor=data['valor'],
            data=datetime.strptime(data.get('data', datetime.utcnow().isoformat()), '%Y-%m-%d').date(),
            categoria=categoria_nome
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

@bp.route('/<int:id>', methods=['GET'])
def obter_lancamento(id):
    cache_key = f"lancamento:{id}"
    # Tenta ler do cache
    cached = redis_client.get(cache_key)
    if cached:
        # Se tiver, retorna direto
        return jsonify(json.loads(cached))

    # Se não tiver no cache, busca no banco
    lancamento = Lancamento.query.get_or_404(id)
    data = lancamento.to_dict()

    # Armazena no cache por 5 minutos (300s)
    redis_client.setex(cache_key, 300, json.dumps(data))

    return jsonify(data)

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