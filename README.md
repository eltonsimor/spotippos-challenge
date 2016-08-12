#Desafio Spotippos

### Tecnologias Utilizadas:
1.  **Junit** para realizar testes unitários da aplicação.
2.  **Spring Boot** utilizei essa tecnologia para criação dos serviços **json**.
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


>_OBS:_ Esse projeto está funcionando no heroku, link para realizar testes: https://spotippos-challenge.herokuapp.com.br/spotippos/properties

### Instruções:

* Foi criado um serviço Rest, onde você envia as Sondas e suas instruções para que elas se movam.
* Para isso, será necessário enviar o request para o serviço. Primeiro vamos subir o WildFly e realizar o deploy do WAR.
* Após subir o WildFly , o serviço POST que será utilizado é ``http://servername:port/explorando-marte-web/rest/explorarMarte  |  Content-Type "application-json``` .
* Para facilitar o mapeamento do request, utilize a seguinte estrutura:

#### Entradas e Saídas:

**Request**
```javascript
echo '{ "x": 222, "y": 444, "title": "Imóvel código 1, com 5 quartos e 4 banheiros", "price": 1250000,  "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",  "beds": 4,  "baths": 3,  "squareMeters": 210}' > request.json && curl -X POST -d @request.json https://spotippos-challenge.herokuapp.com/spotippos/propeties --header "Content-Type:application/json"
```

**Response**
```javascript

```
