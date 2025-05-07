from flask import Flask
from .extensions import db, cache
from . import routes

def create_app():
    app = Flask(__name__)
    app.config.from_object('config.Config')
    
    # Inicializa extensões
    db.init_app(app)
    cache.init_app(app)
    
    # Registra blueprints (rotas)
    app.register_blueprint(routes.bp)
    
    return app