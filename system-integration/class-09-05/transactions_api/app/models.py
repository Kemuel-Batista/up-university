from .extensions import db
from datetime import datetime

class Lancamento(db.Model):
    __tablename__ = 'lancamentos'
    
    id = db.Column(db.Integer, primary_key=True)
    descricao = db.Column(db.String(100), nullable=False)
    valor = db.Column(db.Float, nullable=False)
    data = db.Column(db.Date, nullable=False, default=datetime.utcnow)
    categoria = db.Column(db.String(50), nullable=False)
    
    def to_dict(self):
        return {
            'id': self.id,
            'descricao': self.descricao,
            'valor': self.valor,
            'data': self.data.isoformat(),
            'categoria': self.categoria
        }