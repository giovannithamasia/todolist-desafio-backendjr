<h1 align="center">
  TODO List
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar tarefas (CRUD) que faz parte [desse desafio](https://github.com/simplify-liferay/desafio-junior-backend-simplify) para pessoas desenvolvedoras backend júnior, que se candidatam para a Simplify.

---

## Tecnologias
 
- Spring Boot  
- Spring MVC  
- Spring Data JPA
- SpringDoc OpenAPI 3  
- PostgreSQL  
  
---

## Práticas adotadas

- API REST  
- Consultas com Spring Data JPA  
- Injeção de Dependências  
- Tratamento global de exceções  
- Validações com Bean Validation  
- Versionamento do banco de dados com Flyway  
- Documentação automática da API com Swagger (OpenAPI)  

---

## Como Executar

- Clonar repositório git   
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

Para fazer as requisições HTTP abaixo, você pode usar o Swagger UI do projeto ou qualquer cliente HTTP como Postman:

- Criar Tarefa 
```
POST /todos
{
  "nome": "Todo 1",
  "descricao": "Desc Todo 1",
  "realizado": false,
  "prioridade": "ALTA"
}

Headers de resposta:
201 Created
Location: /todos/1
```

- Listar Tarefas
```
GET /todos

[
  {
    "id": 1,
    "nome": "Todo 1",
    "descricao": "Desc Todo 1",
    "realizado": false,
    "prioridade": "ALTA"
  }
]
```

- Buscar Tarefa pelo ID
```
GET /todos/1

{
  "id": 1,
  "nome": "Todo 1",
  "descricao": "Desc Todo 1",
  "realizado": false,
  "prioridade": "ALTA"
}
```

- Atualizar Tarefa
```
PUT /todos/1
{
  "nome": "Todo 1 Up",
  "descricao": "Desc Todo 1 Up",
  "realizado": true,
  "prioridade": "MEDIA"
}

Headers de resposta:
204 No Content
```

- Remover Tarefa
```
DELETE /todos/1

Headers de resposta:
204 No Content
