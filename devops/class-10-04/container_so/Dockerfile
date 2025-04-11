FROM ubuntu:22.04

# Atualiza e instala dependências necessárias
RUN apt-get update && \
  apt-get install -y mysql-server && \
  rm -rf /var/lib/apt/lists/*

CMD ["mysqld", "--bind-address=0.0.0.0", "--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci"]