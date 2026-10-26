# Payment API - Spring Boot

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue?style=for-the-badge&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED?style=for-the-badge&logo=docker)

API REST desenvolvida como projeto de estudo para aprofundamento em Java, Spring Boot e desenvolvimento de APIs em nível de produção.

O projeto parte de uma implementação CRUD simples e será evoluído progressivamente com conceitos avançados e boas práticas utilizadas no mercado.

---

## Objetivo

Este repositório faz parte da minha jornada de estudos e evolução no ecossistema Java/Spring. 

O objetivo principal não é apenas construir uma API funcional, mas **compreender em profundidade as decisões arquiteturais e os conceitos aplicados**, incluindo:

- Arquitetura em camadas (Controller, Service, Repository)
- Padrão DTO e mapeamento de dados
- Validação com Jakarta Bean Validation
- Persistência de dados com Spring Data JPA e PostgreSQL
- Containerização de ambiente com Docker e Docker Compose
- Tratamento global de exceções
- Paginação e ordenação de dados
- Idempotência em operações críticas
- Controle de concorrência otimista (*Optimistic Concurrency*)
- Versionamento de APIs e compatibilidade retroativa

---

## Tecnologias Utilizadas

- **Linguagem:** Java
- **Framework Principal:** Spring Boot (Spring Web, Spring Data JPA)
- **Validação:** Jakarta Bean Validation
- **Banco de Dados:** PostgreSQL
- **Containerização:** Docker / Docker Compose
- **Utilitários:** Lombok
- **Gerenciador de Dependências:** Maven
- **Testes de API:** Postman

---

## Arquitetura e Fluxo de Dados

A API utiliza uma separação rigorosa de responsabilidades. Para garantir o desacoplamento e proteger a camada de persistência, utilizam-se **DTOs de Entrada (Request DTO)** e **DTOs de Saída (Response DTO)**, evitando a exposição direta das entidades persistidas.

### Fluxo da Requisição (Entrada)
```text
[HTTP Request]
       │
       ▼
  Controller ──────► Validado via Request DTO
       │
       ▼
    Service  ──────► Regra de Negócio / Mapeamento
       │
       ▼
    Entity   ──────► Modelo de Persistência
       │
       ▼
  Repository
       │
       ▼
 [PostgreSQL]
```

### Fluxo da Resposta (Saída)
```text
 [PostgreSQL]
       │
       ▼
    Entity
       │
       ▼
 Service / Converter ──► Converte Entity para Response DTO
       │
       ▼
    Controller
       │
       ▼
[HTTP Response]
```

---

## Funcionalidades Atuais

- [x] Criação de pagamentos
- [x] Listagem geral de pagamentos
- [x] Filtro de pagamentos por status
- [x] Atualização de pagamentos existentes
- [x] Exclusão de pagamentos
- [x] Identificadores únicos utilizando UUID
- [x] Separação clara de Request DTO e Response DTO
- [x] Validação básica de campos nas requisições
- [x] Ambientes de banco de dados PostgreSQL orquestrado via Docker Compose

---

## Endpoints Atuais

> **Nota:** Os endpoints atuais estão na versão inicial e serão refatorados durante os estudos de *resource naming* e *API versioning*.

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/device-payments/payments` | Cria um novo pagamento |
| `GET` | `/device-payments/payments` | Lista todos os pagamentos |
| `GET` | `/device-payments/payments?status=true` | Filtra pagamentos pelo status |
| `PUT` | `/device-payments/payments/{id}` | Atualiza um pagamento existente pelo ID |
| `DELETE` | `/device-payments/payments/{id}` | Remove um pagamento pelo ID |

---

## Roadmap de Evolução

A evolução do projeto é feita de forma incremental para consolidar o aprendizado de cada conceito:

- [x] Separação entre Entity e DTO
- [x] Request DTO e Response DTO desacoplados
- [x] Bean Validation básica nas requisições
- [x] Persistência com PostgreSQL
- [x] Configuração do ambiente PostgreSQL com Docker
- [ ] Revisão do padrao de *resource naming* e verbos HTTP
- [ ] Uso adequado dos códigos de status HTTP (HTTP Status Codes)
- [ ] Tratamento global de exceções (*Global Exception Handling*)
- [ ] Padronização das respostas de erro (RFC 7807 / Problem Details)
- [ ] Paginação e ordenação de resultados
- [ ] Implementação de Idempotência
- [ ] Controle de concorrência otimista (*Optimistic Concurrency*)
- [ ] Versionamento de API (ex: `/v1/payments`)
- [ ] Garantia de compatibilidade retroativa (*Backward Compatibility*)
- [ ] Revisão e mascaramento de informações sensíveis
- [ ] Testes automatizados (Unitários e de Integração)

---

##  Estrutura do Projeto

```text
src/main/java
└── com.viniciusstoc.paymentapispring
    ├── paymentcontroller
    ├── paymentDTO
    │   ├── request
    │   └── response
    ├── paymententity
    ├── paymentrepository
    ├── paymentservice
    └── paymentutils
```

---

## Status do Projeto

 **Em desenvolvimento ativo.** 

As funcionalidades são adicionadas passo a passo com foco no entendimento técnico e nas decisões de design de software, evitando a simples cópia de soluções pronta
