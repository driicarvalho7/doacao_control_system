# Sistema de Coleta de Doações - ONG 🎁🍽️

Este projeto é um sistema para auxiliar a coleta de doações de alimentos de uma ONG, desenvolvido utilizando **Java** para a aplicação desktop e **Node.js** para a API backend. O sistema possibilita a leitura de códigos de barras dos produtos doados através de um leitor conectado via USB, integrando os dados com uma API que armazena as informações em um banco de dados **NoSQL MongoDB**.

## Estrutura do Repositório 📂

O repositório está organizado em duas partes principais:

- **productIn-api**: Contém o código-fonte da API backend desenvolvida em Node.js.
- **productIn-desktop**: Contém o código-fonte da aplicação desktop desenvolvida em Java para a leitura de códigos de barras e interação com a API.

## Tecnologias Utilizadas ⚙️

### API (Backend)
- **Node.js**: Framework para construção da API.
- **MongoDB**: Banco de dados NoSQL para armazenar as informações das doações.
- **Railway**: Plataforma de hospedagem do backend, utilizando contêineres Docker.
- **Docker**: Para empacotamento da API em contêineres.
  
### Aplicação Desktop (Frontend)
- **Java**: Linguagem utilizada para o desenvolvimento da aplicação desktop.
- **ZXing**: Biblioteca para leitura de códigos de barras via USB.

## Funcionalidades 🔧

- Leitura de códigos de barras dos produtos doados, utilizando um leitor de código de barras conectado ao sistema desktop.
- Envio dos dados lidos para a API backend, que realiza o armazenamento das informações em um banco de dados MongoDB.
- Hospedagem da API em um ambiente escalável utilizando Railway e Docker.

## Como Executar 🚀

### Backend (API)

1. Navegue até o diretório productIn-api.
2. Execute o Docker para criar e iniciar o contêiner:
   docker-compose up --build

3. A API estará disponível na URL especificada na configuração de hospedagem do Railway.

### Frontend (Aplicação Desktop)

1. Navegue até o diretório productIn-desktop.
2. Compile e execute a aplicação Java:
   javac Main.java
   java Main

3. Conecte o leitor de código de barras via USB e inicie a coleta de doações.

## Contribuição 🤝

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou pull request com sugestões ou melhorias.

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
