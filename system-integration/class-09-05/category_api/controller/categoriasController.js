const fs = require('fs');
const path = './data/categorias.json';

function lerCategorias(){
    if(!fs.existsSync(path)) return [];
    return JSON.parse(fs.readFileSync(path));
}

function salvarCategorias(dados) {
    fs.writeFileSync(path, JSON.stringify(dados, null, 2));
}

exports.criarCategoria = (req,res) => {
    const { nome } = req.body;

    if(!nome || nome.trim() === ''){
        return res.status(400).json({error:'Nome da categoria é obrigatorio'});
    }

    const categorias = lerCategorias();
    const nova = {
        id: Date.now(),
        nome: nome.trim(),
    };

    categorias.push(nova);
    salvarCategorias(categorias);

    res.status(201).json(nova);
};

exports.listarCategorias = (req, res) => {
    const categorias = lerCategorias();
    res.json(categorias);
};

exports.editarCategoria = (req,res) => {
    const { id } = req.params;
    const { nome } = req.body;

    if (!nome || nome.trim() === ''){
        return res.status(400).json({ error: 'Nome da categoria é obrigatorio'});
    }

    const categorias = lerCategorias();
    const index = categorias.findIndex(cat => String(cat.id) === String(id));

    if (index === -1) {
        return res.status(404).json({ error: 'Categoria nao encontrada'});
    }

categorias[index].nome = nome.trim();
salvarCategorias(categorias);

res.json(categorias[index]);

};

exports.deletarCategoria = (req, res) => {
    const { id } = req.params;
    const categorias = lerCategorias();
    const novaLista = categorias.filter(cat => String(cat.id) !== String(id));

    if(novaLista.length === categorias.length) {
        return res.status(404).json({ error: 'Categoria não encontrada'});
    }

    salvarCategorias(novaLista);
    res.status(204).send();

};