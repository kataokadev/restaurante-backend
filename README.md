# Sistema de Gestão de Restaurante

Um projeto colaborativo para um restaurante, no qual é possível visualizar todo o fluxo da aplicação, desde a criação de produtos, clientes e pedidos.

## Sobre o Projeto

Este sistema simula o fluxo completo de uma aplicação de gestão de restaurante, permitindo a criação e gerenciamento de:

- Produtos
- Clientes
- Pedidos

O projeto foi desenvolvido para demonstrar como essas entidades interagem dentro de um sistema backend completo.

## Meu Papel no Projeto

Eu, **Rafael Kataoka**, fui responsável pelo desenvolvimento do backend, utilizando:

- Java  
- Spring Boot  
- Ecossistema de dependências do Spring Boot (Spring Data JPA, Spring Web, etc.)

## Funcionalidades

- Gestão de produtos (criar, listar, atualizar e deletar)
- Gestão de clientes
- Gestão de pedidos
- Relacionamento entre entidades (Produtos, Clientes e Pedidos)
- Arquitetura RESTful
- Interface web para interação com o sistema

Além da interface web, também é possível interagir com a API utilizando o **Postman**, realizando os seguintes métodos HTTP:

- **POST**
- **GET**
- **PATCH**
- **DELETE**

## Tecnologias Utilizadas

- Java  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- API REST  
- Postman (para testes das requisições)

## 🔥 Exemplo de Uso com Postman

É possível utilizar o **Postman** para realizar requisições HTTP na API.

Por exemplo, é possível criar um cliente utilizando uma requisição **POST** no seguinte endpoint:


POST https://restaurante-backend-production-51a8.up.railway.app/clientes/criar


### 🔥 Corpo da requisição (JSON)

```json
{
  "nome": "DEV",
  "telefone": "43 99999-9999"
}
```

Essa requisição irá cadastrar um novo cliente no sistema.

## Estrutura do Projeto

O backend foi estruturado seguindo os princípios REST, garantindo separação entre:

Controllers
Services
Repositories
Entidades

## 🔥 Autor

Rafael Kataoka
