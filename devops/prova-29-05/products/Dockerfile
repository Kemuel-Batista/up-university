FROM node:22.16-alpine

WORKDIR /app

COPY . .

RUN npm ci

EXPOSE 3001

CMD ["node", "server.js"]
