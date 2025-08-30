# CRUD Registro de Serviços - Spring Boot

Este projeto é um **CRUD (Create, Read, Update, Delete) para registrar serviços** realizados por uma empresa ou técnico, desenvolvido em **Spring Boot 3.x** com **Java 24**, utilizando **H2 Database**, **JPA** e **Lombok**. O sistema funciona como uma **agenda de serviços**, permitindo registrar, consultar, atualizar e deletar serviços prestados aos clientes.

## Tecnologias utilizadas

- Java 24
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (em memória)
- Lombok
- Maven

## Funcionalidades

O sistema permite:

- Registrar novos serviços com informações do cliente e detalhes do serviço
- Consultar serviços pelo protocolo
- Atualizar informações de serviços, mantendo os campos não alterados
- Deletar serviços pelo protocolo

Campos principais do projeto:

- `protocolo` (único para cada serviço)
- `nome` do cliente
- `email` do cliente (único)
- `cpfCliente` (único)
- `telefone` (único)
- `endereco`
- `descricao` do serviço
- `valorTotal`

> Cada serviço é identificado por um **protocolo único**, que funciona como chave de consulta.

## Observações

- O banco H2 está em memória, então os dados são perdidos ao fechar a aplicação.
- Lombok é usado para reduzir getters/setters, construtores e builders, facilitando atualizações parciais dos serviços.
- A atualização de serviço mantém os campos existentes caso não sejam enviados no RequestBody
