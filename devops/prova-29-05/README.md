## Prova Devops - 29-05

### Dockerfile de cada projeto

#### Dockerfile - Products API em Node JS

1. Iniciamos a instrução com: Baixando a imagem oficial do node
2. Definimos o diretório em /app
3. Copiamos todos os arquivos da pasta /products para dentro de /app
4. Rodamos o comando de instalação do node com o ```npm ci```
5. Expoê para fora do container a porta 3001
6. Rodamos o comando: node server.js dentro do container para iniciar e rodar a aplicação

#### Dockerfile - Orders API em Python

1. Iniciamos a instrução com: Baixando a imagem oficial do python
2. Definimos o diretório em /app
3. Copiamos o arquivo de requirements.txt para a pasta /app (intrução em .)
4. Baixamos as dependências que estão listadas no requirements.txt
5. Copiamos o restante dos arquivos para dentro do diretório /app
6. Expoê para fora do container a porta 3002
7. Roda o comando do python para iniciar e rodar a aplicação

#### Dockerfile - Payments API em PHP

1. Iniciamos a instrução com: Baixando a imagem oficial do php
2. Definimos o diretório em /var/www/html
3. Copiamos todos os arquivos da pasta /payments para dentro de /app
4. Expoê para fora do container a porta 3003
5. Comando para rodar o servidor php para qualquer IP na porta 3003 (Instrução: php -S 0.0.0.0:3003)

### Docker Compose

O docker-compose.yml builda e executa 5 containers na mesma rede: ecommerce_network (Necessário para que a comunicação entre os containers funcione corretamente).

#### DB Service

Nesse passo estamos instanciando o mysql da imagem oficial do bitnami (bitnami/mysql:latest) também definimos que a porta exporta do container é 3306 e a porta exporta para nosso computador é o 3306.
Também adicionamos algumas variáveis de ambiente para que nosso banco mysql seja instanciado com as credenciais e também um banco default chamado: ecommerce.

#### Redis Service

Nesse passo estamos instanciando o redis da imagme oficial do bitnami (bitnami/redis:latest) também definimos que a porta exporta do container é 6379 e a porta exporta para nosso computador é o 6379. Definimos qual é a senha de acesso default e também passamos um volume que garante que os dados não se percam ao parar ou remover o container.

#### Products API Service

Nesse passo estamos instanciando nossa api de produtos.
```build: ./products``` indica ao docker que o Dockerfile desse container está em /products e deve fazer o build a partir de lá.
Também expomos a porta 3001

#### Orders API Service

Nesse passo estamos instanciando nossa api de pedidos.
```build: ./orders``` indica ao docker que o Dockerfile desse container está em /orders e deve fazer o build a partir de lá.
Também expomos a porta 3002. Colocamos como dependencia a nossa api de products, redis e db. Isso garante com que o nosso serviço do python não instancie enquanto esses outros itens ainda não estiverem instanciados previamente.

#### Payments API Service

Nesse passo estamos instanciando nossa api de pedidos.
```build: ./payments``` indica ao docker que o Dockerfile desse container está em /payments e deve fazer o build a partir de lá.
Também expomos a porta 3003. Colocamos como dependencia a nossa api de orders. Isso garante com que o nosso serviço do php não instancie enquanto esses outros itens ainda não estiverem instanciados previamente.

#### Networks:

Define uma network para os containers

#### Volumes

Instancia os volumes para as imagens (mysql e redis)