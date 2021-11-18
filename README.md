# Validação da senha de login
Api para validacao de senha

# Executar o projeto
Rodar o projeto com o comando: 

```bash
mvn spring-boot:run
```

POST
http://localhost:8080/validacao

Exemplo de entrada:

```json
{"password": "AbTp9!fok"}
```

# Detalhes sobre a solução
Para mapear os casos de validação de senha, foi pensada a utilização da expressão regular abaixo:
```text
^(?=.*?[A-Z])
(?=.*?[a-z])
(?=.*?[0-9])
(?=.*?[#?!@$%^&*-])
.{9,}$
```
Foi pensada também uma validação separada para evitar a repetição ed caracteres na string.
Para enviar a informação da senha e não armazenar a informação, utiliza-se o método POST.
