# 🏦 API de Sistema de Empréstimos (Loan System)

Uma API RESTful desenvolvida em Java e Spring Boot para analisar o perfil de clientes e sugerir modalidades de empréstimos personalizadas com base em regras de negócio específicas.

## 🚀 Tecnologias Utilizadas
* **Java 17+**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **H2 Database** (Banco de dados em memória)
* **Lombok** (Redução de boilerplate)

## 📌 Regras de Negócio Implementadas
A API avalia a elegibilidade do cliente seguindo os seguintes critérios:

* **Empréstimo Pessoal (PERSONAL):** Taxa de 4%. Liberado para clientes com renda entre R$ 500,00 e R$ 5.000,00 (inclusive).
* **Empréstimo Consignado (CONSIGMENT):** Taxa de 2%. Liberado para clientes com renda superior a R$ 5.000,00.
* **Empréstimo com Garantia (GUARANTEED):** Taxa de 3%. Liberado para clientes com idade até 30 anos que residam em São Paulo (SP).

---

## 🔗 Endpoints da API

**URL Base:** `http://localhost:8080/api/v1/loan`

### 1. Criar Cliente
Registra um novo cliente no sistema.

* **Rota:** `POST /user`
* **Corpo da Requisição (JSON):**

```json
{
  "name": "Maria Silva",
  "cpf": "123.456.789-00",
  "age": 28,
  "location": "SP",
  "income": 5000.00
}
```

* **Respostas:**
    * `201 Created`: Cliente salvo com sucesso. Retorna os dados do cliente salvo e o link para consultar os empréstimos no *Header* `Location`.
    * `400 Bad Request`: Caso tente cadastrar um CPF já existente (Retorna mensagem de erro limpa).

---

### 2. Consultar Opções de Empréstimo
Avalia o perfil do cliente pelo ID e retorna os empréstimos pré-aprovados.

* **Rota:** `GET /{id}/loan-options`
* **Parâmetros de Rota:**
    * `id` (Obrigatório): O ID numérico do cliente salvo no banco.

* **Exemplo de Resposta de Sucesso (`200 OK`):**

```json
{
  "customer": "Maria Silva",
  "loans": [
    {
      "type": "PERSONAL",
      "interest_rate": 4
    },
    {
      "type": "GUARANTEED",
      "interest_rate": 3
    }
  ]
}
```

* **Respostas de Erro:**
    * `400 Bad Request`: Caso o cliente não se encaixe em nenhuma regra de empréstimo. Retorna a mensagem: "Sem emprestimos por enquanto".

---

## ⚠️ Observação sobre Segurança (IDs)

Atualmente, a API utiliza um ID numérico simples (gerado sequencialmente ou de forma aleatória) para identificar os clientes. Para um ambiente de produção ou para garantir maior segurança contra ataques de enumeração (onde um usuário mal-intencionado poderia tentar adivinhar o ID de outras pessoas mudando os números na URL), **recomenda-se alterar a entidade principal para utilizar UUID** (`java.util.UUID`) como chave primária em vez de `Long`.
