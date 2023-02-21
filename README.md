# CRUD

Esse projeto foi criado com o intuito de aplicar os meus conhecimentos sobre CRUD.

É uma API simples que permite o cadastro de carros, com as seguintes informações (Só um exemplo):
```Json
{
	"modelo": "Gol",
	"ano": 2010,
	"valor": 30000.0
}
```


## Tecnologias utilizadas

- <a href="https://www.java.com/">Java</a>
- <a href="https://spring.io/projects/spring-boot">Spring Boot</a>
- <a href="https://spring.io/projects/spring-data-jpa">Spring Data JPA</a>
- <a href="https://www.docker.com/">Docker</a>
- <a href="https://www.postgresql.org/">PostgreSQL</a>

---
## Como executar o projeto

Após clonar o projeto, certifique-se de estar na raiz do projeto e execute o seguinte comando:

###### Obs: É necessário ter o docker instalado na sua máquina e ter as portas 8080 e 5432 livres.

```bash
docker-compose up -d
```

Após a execução do comando acima, o projeto estará disponível em http://localhost:8080

---
## Como fazer requisições

Para fazer requisições, você pode utilizar o <a href="https://www.postman.com/">Postman</a> ou o <a href="https://insomnia.rest/">Insomnia</a>.

### Endpoints

### GET	
Requisitar todos os carros cadastrados:
```
localhost:8080/carros
```

Requisitar um carro específico:
```
localhost:8080/carros/gol
```

### POST
- Cadastrar um novo carro. **Os dados devem ser enviados no corpo da requisição.**
```
localhost:8080/carros
```
```Json
{
	"modelo": "Gol",
	"ano": 2010,
	"valor": 30000.0
}
```

### PUT

Atualizar um carro já cadastrado.
```
localhost:8080/carros/gol
```
```Json
{
	"modelo": "Palio",
	"ano": 2010,
	"valor": 30000.0
}
```

Isso permite que você altere todos os dados do carro, ou apenas alguns deles.

### DELETE

Deletar um carro já cadastrado.
```
localhost:8080/carros/gol
```

---

## Como parar o projeto

Para parar o projeto, execute o seguinte comando:

```bash
docker-compose down
```

---

Obrigado por ler até aqui! :smile: