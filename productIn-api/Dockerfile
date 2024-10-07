# Usando a imagem Node.js
FROM node:16

# Definindo diretório de trabalho
WORKDIR /usr/src/app

# Copiando package.json e package-lock.json
COPY package*.json ./

# Instalando dependências
RUN npm install

# Copiando código fonte
COPY . .

# Expondo a porta da API
EXPOSE 3000

# Definindo a variável padrão NODE_ENV como 'production'
ENV NODE_ENV=production

# Comando para rodar a aplicação
CMD ["npm", "start"]
