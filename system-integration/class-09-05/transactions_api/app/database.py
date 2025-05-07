from .extensions import db
import time
from sqlalchemy import exc

def wait_for_db(app, max_retries=5, retry_delay=5):
    """Aguarda até que o banco de dados esteja disponível"""
    with app.app_context():
        for attempt in range(max_retries):
            try:
                db.engine.connect()
                print("✅ Conexão com PostgreSQL estabelecida com sucesso!")
                return True
            except exc.OperationalError as e:
                print(f"⚠️ Tentativa {attempt + 1}/{max_retries}: PostgreSQL não disponível. Erro: {e}")
                if attempt < max_retries - 1:
                    time.sleep(retry_delay)
        
        print(f"❌ Não foi possível conectar ao PostgreSQL após {max_retries} tentativas")
        return False

def create_tables(app):
    """Cria as tabelas no banco de dados"""
    if not wait_for_db(app):
        raise RuntimeError("Não foi possível conectar ao banco de dados")
    
    print("🛠 Criando tabelas no banco de dados...")
    try:
        with app.app_context():
            db.create_all()
        print("✅ Tabelas criadas com sucesso!")
    except Exception as e:
        print(f"❌ Erro ao criar tabelas: {e}")
        raise