const express = require('express');
const bodyParser = require('body-parser');
const authRoutes = require('./routes/authRoutes');
const swaggerUi = require('swagger-ui-express');
const swaggerDocument = require('../swagger/swagger.json');
const dotenv = require('dotenv');

// Carrega variáveis de ambiente de acordo com NODE_ENV
const environment = process.env.NODE_ENV || 'development';
dotenv.config({ path: `.env.${environment}` });

console.log(`Running in ${environment} mode`);
console.log(`Loaded SECRET_KEY: ${process.env.SECRET_KEY}`);

const app = express();
const port = process.env.PORT || 3000;

// Log para verificar qual ambiente está sendo carregado
console.log(`Running in ${environment} mode`);

app.use(bodyParser.json());

// Rotas de autenticação
app.use('/api/auth', authRoutes);

// Documentação Swagger
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

app.listen(port, () => {
    console.log(`API rodando na porta ${port}`);
});
