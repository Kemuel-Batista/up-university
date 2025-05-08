const { db, redis } = require('./db');

exports.criarCategoria = async (req, res) => {
    const { nome } = req.body;

    if (!nome || nome.trim() === '') {
        return res.status(400).json({ error: 'Nome da categoria é obrigatório' });
    }

    try {
        const result = await db.query(
            'INSERT INTO category (name) VALUES ($1) RETURNING *',
            [nome.trim()]
        );

        // Invalida o cache
        await redis.del(`category:${nome.trim()}`);

        res.status(201).json(result.rows[0]);
    } catch (err) {
        res.status(500).json({ error: 'Erro ao criar categoria' });
    }
};

exports.listarCategorias = async (req, res) => {
    try {
        const result = await db.query('SELECT * FROM category ORDER BY id');
        res.json(result.rows);
    } catch (err) {
        res.status(500).json({ error: 'Erro ao listar categorias' });
    }
};

exports.editarCategoria = async (req, res) => {
    const { id } = req.params;
    const { nome } = req.body;

    if (!nome || nome.trim() === '') {
        return res.status(400).json({ error: 'Nome da categoria é obrigatório' });
    }

    try {
        const result = await db.query(
            'UPDATE category SET name = $1 WHERE id = $2 RETURNING *',
            [nome.trim(), id]
        );

        if (result.rowCount === 0) {
            return res.status(404).json({ error: 'Categoria não encontrada' });
        }

        await redis.del(`category:${nome.trim()}`);

        res.json(result.rows[0]);
    } catch (err) {
        res.status(500).json({ error: 'Erro ao editar categoria' });
    }
};

exports.deletarCategoria = async (req, res) => {
    const { id } = req.params;

    try {
        const result = await db.query(
            'DELETE FROM category WHERE id = $1 RETURNING *',
            [id]
        );

        if (result.rowCount === 0) {
            return res.status(404).json({ error: 'Categoria não encontrada' });
        }

        await redis.del(`category:${result.rows[0].name}`);

        res.status(204).send();
    } catch (err) {
        res.status(500).json({ error: 'Erro ao deletar categoria' });
    }
};

exports.obterCategoriaPorNome = async (req, res) => {
    const { name } = req.params;

    try {
        const cacheHit = await redis.get(`category:${name}`);

        if (cacheHit) {
            return res.json(JSON.parse(cacheHit));
        }

        const result = await db.query('SELECT * FROM category WHERE name = $1', [name]);

        const category = result.rows[0];

        if (!category) return res.status(404).json({ error: 'Categoria não encontrada' });

        await redis.set(`category:${name}`, JSON.stringify(category));

        res.json(category);
    } catch (err) {
        res.status(500).json({ error: 'Erro ao buscar categoria' });
    }
};
