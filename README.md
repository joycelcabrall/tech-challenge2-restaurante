# Tech Challenge - Fase 2

## Descrição do Projeto

Este projeto consiste no desenvolvimento de um sistema de gestão para restaurantes, permitindo o cadastro e gerenciamento de usuários, restaurantes, produtos e pedidos.

A proposta do sistema é atender múltiplos restaurantes em uma única aplicação, permitindo que clientes escolham estabelecimentos com base na comida oferecida.

O sistema foi desenvolvido utilizando Java com Spring Boot, seguindo boas práticas de organização em camadas.

---

## Objetivo da Fase 2

Implementar as seguintes funcionalidades:

- Cadastro de tipos de usuário
- Cadastro de usuários
- Cadastro de restaurantes
- Cadastro de itens do cardápio (produtos)
- Criação e gerenciamento de pedidos

Além disso, aplicar:

- Organização em camadas (Controller, Service, Repository, Entity)
- Persistência em banco de dados relacional
- Testes dos endpoints via Postman
- Execução da aplicação com Docker

---

## Funcionalidades

### Tipo de Usuário
- Criar tipo de usuário
- Listar tipos
- Buscar por ID
- Atualizar tipo
- Deletar tipo

### Usuários
- Criar usuário
- Associar com tipo de usuário
- Listar usuários
- Buscar por ID
- Atualizar usuário
- Deletar usuário

### Restaurantes
- Criar restaurante
- Associar com dono (usuário)
- Listar restaurantes
- Buscar por ID
- Atualizar restaurante
- Deletar restaurante

### Produtos (Cardápio)
- Criar produto
- Associar com restaurante
- Listar produtos
- Buscar por ID
- Atualizar produto
- Deletar produto

### Pedidos
- Criar pedido
- Associar com usuário (cliente)
- Associar com restaurante
- Adicionar itens ao pedido
- Listar pedidos

---

## Arquitetura

O sistema foi estruturado em camadas:

- Controller: Responsável pelos endpoints da API
- Service: Contém a lógica de negócio
- Repository: Responsável pelo acesso ao banco de dados
- Entity: Representação das entidades

Essa organização facilita manutenção, testes e escalabilidade.

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL
- Docker
- Postman

---

## Configuração do Banco de Dados

A aplicação utiliza PostgreSQL.

Configuração padrão no arquivo application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/tech_challenge  
spring.datasource.username=postgres  
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  
spring.jpa.properties.hibernate.format_sql=true

É necessário que o banco tech_challenge esteja criado previamente.

---

## Como Executar o Projeto

### Execução Local

1. Iniciar o PostgreSQL
2. Criar o banco de dados:  
   CREATE DATABASE tech_challenge;
3. Ajustar usuário e senha no application.properties
4. Executar a classe RestauranteApplication
5. A aplicação estará disponível em: http://localhost:8080

---

### Execução com Docker

Na raiz do projeto, execute:

docker compose up --build

A aplicação será iniciada juntamente com o banco de dados.

---

## API

Base URL:

http://localhost:8080

---

## Postman

A coleção do Postman está disponível em:

postman/restaurante-postman.json

### Como importar:

1. Abrir o Postman
2. Clicar em Import
3. Selecionar o arquivo JSON da pasta postman
4. Executar as requisições disponíveis

---

## Estrutura do Projeto

restaurante/  
├── src/  
├── postman/  
│   └── restaurante-postman.json  
├── docker-compose.yml  
├── Dockerfile  
├── pom.xml  
└── README.md

---

## Considerações Finais

O sistema atende aos requisitos propostos para a fase, permitindo o gerenciamento completo de restaurantes, usuários, produtos e pedidos.

A aplicação foi estruturada utilizando boas práticas de desenvolvimento, com separação em camadas, persistência em banco de dados e testes dos endpoints via Postman.