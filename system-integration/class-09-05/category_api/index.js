const express = require('express');
const bodyParser = require('body-parser');
const categoriasRoutes = require('./routes/categorias');
const transacoesRoutes = require('./routes/transacoes');


const app = express();
app.use(bodyParser.json());

app.use('./categorias', categoriasRoutes);
app.use('./transacoes', transacoesRoutes);

const PORT = 3003;
app.listen(PORT, () => {
    console.log(`API de categorias e metas rodando na porta ${PORT}`);
});