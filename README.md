<h1 align="center">
BookStore
</h1>

<p align="center">
 
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>
O projeto "BookStore" é uma aplicação desenvolvida com o Spring Boot, que permite a criação de uma livraria online. Utilizando o Spring Data JPA, é possível gerenciar os dados dos livros, como o cadastro, atualização e remoção. A aplicação também disponibiliza uma API REST para consulta e interação com os livros. A documentação da API é gerada automaticamente usando o SpringDoc OpenAPI. O projeto utiliza um banco de dados MySQL para armazenar as informações dos livros.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Dev Tools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html)
- [Spring Data Jpa](https://spring.io/projects/spring-data-jpa)
- [Mysql](https://www.mysql.com/)

## Práticas adotadas

- API rest na web e na camada de banco
- Uso de DTOs para a API
- Injeção de Dependências
- Auditoria sobre criação e atualização da entidade

## Como Executar

### Localmente
- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar place-service/target/book-store-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Usando Docker

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name book-store -p 8080:8080  -d place-service:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

