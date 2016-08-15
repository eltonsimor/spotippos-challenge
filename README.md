#Desafio Spotippos

## Tecnologias Utilizadas:
1.  **Spring Boot** utilizei essa tecnologia para criação dos serviços **REST**.
2.  **Spring Boot Test** para realizar  **Testes Integrados**.
3.  **Junit** para realizar **Testes Unitários**.
4.  **JavaEE-API** para validação das entradas do request.
5.  **log4j** para logar erro caso tenha alguma exception.
6.  **Jetty** container para roda a aplicação
7.  **Java 8** línguagem de programação versão 8.
8.  **Gradle** para gerenciamento de dependências.
9.  **Design Pattern Strategy** padrão de desenvolvimento.
10.  **Guava** para calcular o range e obter as propriedade.
11. **Gson** para converter os serviços REST.
12. **Dozer** para converter qualquer tipo de objeto comparado pelos mesmos nomes de variaveis.
13. **Heroku** Esse projeto está preparado para rodar nos servidores Heroku.


>_OBS:_ Esse projeto está funcionando no heroku, link para realizar testes:
<p>http://spotippos-challenge.herokuapp.com/spotippos/properties/1

## Instruções para subir a aplicação Local:

#### Pré-Requisito:

* 1) Ter o Java 8 Instalado [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
* 2) Ter o Gradle [Gradle](https://services.gradle.org/distributions/gradle-2.14.1-all.zip).



#### Após realizar o pré-requisito vamos seguir o passo-a-passo

* 1) realizar o clone do projeto.
```javascript
    git clone https://github.com/eltonsimor/spotippos-challenge.git
```

* 2) Acessar a raíz do projeto e executar o comando:
```javascript
    'gradle build'
```

* 3) Após a finalização do build, executar o comando:
```javascript
    'java -jar build\libs\spotippos-challenge-1.0.0.jar'
```

>Pronto! Aplicação já pode ser utilizada! ;)


**Request para o ambiente Heroku**

_Request para salvar uma nova propriedade:_
```javascript
echo '{ "x": 222, "y": 444, "title": "Imóvel código 1, com 5 quartos e 4 banheiros", "price": 1250000,  "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",  "beds": 4,  "baths": 3,  "squareMeters": 210}' | curl -X POST -d @- http://spotippos-challenge.herokuapp.com/spotippos/properties --header "Content-Type:application/json"
```

_Request para obter uma propriedade pelo ID:_
```javascript
curl -X GET http://spotippos-challenge.herokuapp.com/spotippos/properties/2000 --header "Content-Type:application/json"
```

_Request para obter propriedade definido por um range de coordenadas_
```javascript
curl -X GET -G 'http://spotippos-challenge.herokuapp.com/spotippos/properties' -d ax=0 -d ay=500 -d bx=600 -d by=1000
```

**Request para o ambiente Local**

_Request para salvar uma nova propriedade:_
```javascript
echo '{ "x": 222, "y": 444, "title": "Imóvel código 1, com 5 quartos e 4 banheiros", "price": 1250000,  "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",  "beds": 4,  "baths": 3,  "squareMeters": 210}' | curl -X POST -d @- http://localhost:8080/spotippos/properties --header "Content-Type:application/json"
```

_Request para obter uma propriedade pelo ID:_
```javascript
curl -X GET http://localhost:8080/spotippos/properties/2000 --header "Content-Type:application/json"
```

_Request para obter propriedade definido por um range de coordenadas_
```javascript
curl -X GET -G 'http://localhost:8080/spotippos/properties' -d ax=0 -d ay=500 -d bx=600 -d by=1000
```
