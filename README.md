#  Tech Challenge - Fase 2

## Descrição do Projeto

Este projeto consiste no desenvolvimento de um sistema de gestão para restaurantes, permitindo o cadastro e gerenciamento de usuários, restaurantes e itens do cardápio.

A proposta do sistema é atender múltiplos restaurantes em uma única aplicação, permitindo que clientes escolham estabelecimentos com base na comida oferecida.

O sistema foi desenvolvido utilizando Spring Boot, seguindo boas práticas de desenvolvimento e organização em camadas.

---

##  Objetivo da Fase 2

Implementar as seguintes funcionalidades:

- Cadastro de tipos de usuário
- Cadastro de usuários
- Cadastro de restaurantes
- Cadastro de itens do cardápio

Além disso, aplicar:

- Organização em camadas
- Testes via Postman
- Execução com Docker

---

##  Funcionalidades

###  Tipo de Usuário
- Criar tipo de usuário
- Listar tipos
- Buscar por ID
- Atualizar tipo
- Deletar tipo

---

###  Usuários
- Criar usuário
- Associar com tipo de usuário
- Listar usuários
- Buscar por ID
- Atualizar usuário
- Deletar usuário

---

### Restaurantes
- Criar restaurante
- Associar com dono
- Listar restaurantes
- Buscar por ID
- Atualizar restaurante
- Deletar restaurante

---

###  Produtos (Cardápio)
- Criar produto
- Associar com restaurante
- Listar produtos
- Buscar por ID
- Atualizar produto
- Deletar produto

---

##  Arquitetura

O sistema foi estruturado em camadas:

- **Controller** → Responsável pelos endpoints da API
- **Service** → Contém a lógica de negócio
- **Repository** → Responsável pelo acesso ao banco de dados
- **Entity** → Representação das entidades

Essa organização facilita manutenção, testes e escalabilidade.

---

##  Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Maven
- MySQL
- Docker
- Postman

---

##  Como Executar o Projeto

###  Rodando com Docker

Na raiz do projeto, execute:

```bash
docker compose up --build