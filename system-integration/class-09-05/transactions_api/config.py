import os

class Config:
    # PostgreSQL
    SQLALCHEMY_DATABASE_URI = os.getenv('DATABASE_URL', 'postgresql://postgres:postgres@db:5432/system-integration')
    SQLALCHEMY_TRACK_MODIFICATIONS = False
    
    # Redis
    REDIS_URL = os.getenv('REDIS_URL', 'redis://redis:6379/0')
    
    # Segurança
    SECRET_KEY = os.getenv('SECRET_KEY', 'dksaodiq90ei23-udnakjdpasioid9auds')