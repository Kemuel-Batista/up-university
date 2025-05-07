const express = require('express');
const router = express.Router();
const controller = require('../controller');

router.post('/', controller.criarCategoria);
router.get('/', controller.listarCategorias);
router.put('/', controller.editarCategorias);
router.delete('/', controller.deletarCategoria);

module.exports = router;
