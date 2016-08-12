#Desafio Spotippos

### Tecnologias Utilizadas:
1.  **Spring Boot** utilizei essa tecnologia para criação dos serviços **json**.
2.  **Junit** para realizar **Testes Unitários** da aplicação e **Testes Integrados**.
3.  **JavaEE-API** para validação das entradas do request.
4.  **log4j** para logar erro caso tenha alguma exception.
5.  **Jetty** container para roda a aplicação
6.  **Java 8** línguagem de programação versão 8.
7.  **Gradle** para gerenciamento de dependências.
8.  **Design Pattern Strategy** padrão de desenvolvimento.
9.  **Guava** para calcular o range e obter as propriedade.
10. **GSON** para converter os serviços JSON.
11. **DOZER** para converter qualquer tipo de objeto comparado pelos mesmos nomes de variaveis.
12. **HEROKU** Esse projeto está preparado para rodar em qualquer servidor Heroku.


>_OBS:_ Esse projeto está funcionando no heroku, link para realizar testes: https://spotippos-challenge.herokuapp.com.br/spotippos/

### Instruções:

* is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.

#### Entradas e Saídas:

**Request**

```javascript
echo '{ "x": 222, "y": 444, "title": "Imóvel código 1, com 5 quartos e 4 banheiros", "price": 1250000,  "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",  "beds": 4,  "baths": 3,  "squareMeters": 210}' | curl -X POST -d @- https://spotippos-challenge.herokuapp.com/spotippos/properties --header "Content-Type:application/json"
```

**Response**
```javascript

```
