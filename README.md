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
10. **Gson** para converter os serviços JSON.
11. **Dozer** para converter qualquer tipo de objeto comparado pelos mesmos nomes de variaveis.
12. **Heroku** Esse projeto está preparado para rodar em qualquer servidor Heroku.


>_OBS:_ Esse projeto está funcionando no heroku, link para realizar testes:
<p>http://spotippos-challenge.herokuapp.com/spotippos/properties/1

### Instruções:

* is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.

#### Entradas e Saídas:

**Request Utilizando o Heroku**

_Request para salvar uma nova propriedade:_
```javascript
echo '{ "x": 222, "y": 444, "title": "Imóvel código 1, com 5 quartos e 4 banheiros", "price": 1250000,  "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",  "beds": 4,  "baths": 3,  "squareMeters": 210}' | curl -X POST -d @- https://spotippos-challenge.herokuapp.com/spotippos/properties --header "Content-Type:application/json"
```

_Request para obter uma propriedade pelo ID:_
```javascript
curl -X GET http://spotippos-challenge.herokuapp.com/spotippos/properties/2000 --header "Content-Type:application/json"
```

_Request para obter propriedade definido por um range de coordenadas_
```javascript
curl -X GET -G 'http://spotippos-challenge.herokuapp.com/spotippos/properties' -d ax=0 -d ay=500 -d bx=600 -d by=1000
```

**Response**
```javascript

```
