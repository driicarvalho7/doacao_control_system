const express = require('express');
const router = express.Router();
const authController = require('../controllers/authController');
const authMiddleware = require('../middlewares/authMiddleware');

// Rota de login
router.post('/login', authController.login);

// Rota protegida
router.get('/protected', authMiddleware.verifyToken, authController.protected);

module.exports = router;
