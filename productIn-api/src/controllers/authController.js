const jwt = require('jsonwebtoken');
const dotenv = require('dotenv');

// Carrega variáveis de ambiente de acordo com NODE_ENV
const environment = process.env.NODE_ENV || 'development';
dotenv.config({ path: `.env.${environment}` });

const SECRET_KEY = process.env.SECRET_KEY;

// Simulação de um banco de usuários
const users = [
    { id: 1, username: 'user1', password: 'password1', role: 'admin' },
    { id: 2, username: 'user2', password: 'password2', role: 'user' },
];

// Função de login
exports.login = (req, res) => {
    const { username, password } = req.body;
    const user = users.find(u => u.username === username && u.password === password);

    if (user) {
        const token = jwt.sign({ id: user.id, role: user.role }, SECRET_KEY, { expiresIn: '1h' });
        res.json({ token });
    } else {
        res.status(401).json({ message: 'Credenciais inválidas' });
    }
};

// Função protegida
exports.protected = (req, res) => {
    res.json({ message: 'Acesso concedido à rota protegida', userId: req.userId, role: req.role });
};
