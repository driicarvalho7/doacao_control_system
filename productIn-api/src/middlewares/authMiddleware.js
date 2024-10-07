const jwt = require('jsonwebtoken');
const dotenv = require('dotenv');

// Carrega variáveis de ambiente de acordo com NODE_ENV
const environment = process.env.NODE_ENV || 'development';
dotenv.config({ path: `.env.${environment}` });

const SECRET_KEY = process.env.SECRET_KEY;

exports.verifyToken = (req, res, next) => {
    const token = req.headers['authorization'];

    if (!token) {
        return res.status(403).json({ message: 'Token não fornecido' });
    }

    jwt.verify(token, SECRET_KEY, (err, decoded) => {
        if (err) {
            return res.status(403).json({ message: 'Falha ao autenticar token' });
        }

        req.userId = decoded.id;
        req.role = decoded.role;
        next();
    });
};
