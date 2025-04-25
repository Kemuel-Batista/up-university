

```markdown
# Projeto MySQL com Docker + NestJS

Este projeto configura uma instância MySQL 8.0 com Docker, e integra com uma aplicação NestJS. Ideal para ambientes de desenvolvimento com persistência de dados.

## 🚀 Requisitos

- [Docker](https://www.docker.com/)
- [Node.js](https://nodejs.org/)
- [Nest CLI](https://docs.nestjs.com/cli/overview)
- Cliente MySQL (opcional)

---

## 🐳 Comandos Docker

### Subindo o banco de dados MySQL:

```bash
docker run --name root \
  --rm \
  -v /tmp/mysql-data:/var/lib/mysql \
  -e MYSQL_ROOT_PASSWORD=positivo \
  -e MYSQL_DATABASE=positivo \
  -p 3307:3306 \
  -it mysql:8.0
```

### Build da aplicação NestJS:

```bash
docker build -t project_nest .
```

---

## ⚙️ Conectando o NestJS ao MySQL

Você pode usar **TypeORM**, **Prisma** ou **Sequelize**. Aqui está um exemplo com TypeORM:

### Instale os pacotes necessários:

```bash
npm install @nestjs/typeorm typeorm mysql2
```

### Configure o módulo no `AppModule`

```ts
import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 3307,
      username: 'root',
      password: 'positivo',
      database: 'positivo',
      autoLoadEntities: true,
      synchronize: true, // somente em desenvolvimento
    }),
  ],
})
export class AppModule {}
```

---

## 🧪 Testando a conexão

### Dentro do container:

```bash
docker exec -it root mysql -u root -p
```

### Externamente:

```bash
mysql -h 127.0.0.1 -P 3307 -u root -p
```

---

## 📂 Persistência

Os dados são salvos em `/tmp/mysql-data` no seu sistema, mantendo o estado mesmo após o container ser encerrado.

---

## 📌 Dicas

- **Evite `synchronize: true` em produção.**
- Use `.env` para manter as credenciais fora do código.
- Certifique-se de que a porta `3307` está livre.
- Se quiser rodar sua aplicação NestJS via Docker após o build, use:
  ```bash
  docker run -p 3000:3000 project_nest
  ```

---

Feito com 💻 por Jhonny Guimarães
```

