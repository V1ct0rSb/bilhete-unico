# API de Gerenciamento de Bilhete Único 💳

Este projeto é uma API RESTful desenvolvida em Java com Spring Boot para simular o sistema de gerenciamento de um Bilhete Único. A API permite o cadastro de usuários, a criação de cartões, recargas, utilização em transportes e consulta de extratos.

## ✨ Funcionalidades

- **👤 Gestão de Usuários:** Cadastrar e buscar usuários por CPF ou ID.
- **💳 Gestão de Cartões:** Criar cartões do tipo `COMUM`, `ESTUDANTE` ou `IDOSO`, associados a um usuário.
- **🔢 Geração de Número:** Geração automática de um número de 4 dígitos único para cada cartão.
- **💸 Transações:**
  - Efetuar recargas em um cartão.
  - Simular o uso do cartão em ônibus ou metrô.
  - Débito de tarifas diferenciadas:
    - **Comum:** R$ 4,40
    - **Estudante:** R$ 2,20
    - **Idoso:** R$ 0,00 (Gratuidade)
- **📊 Consultas:**
  - Consultar saldo e dados de um cartão.
  - Listar todo o histórico de transações de um cartão.
- **⚙️ Tratamento de Erros:** Respostas de erro claras para validações, dados não encontrados ou regras de negócio (ex: saldo insuficiente).

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Maven**

---

## 📖 Endpoints da API

<img width="1446" height="600" alt="image" src="https://github.com/user-attachments/assets/2a852faf-a79b-4291-886a-896dd123f2dd" />

