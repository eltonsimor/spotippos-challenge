# Desafio Spotippos

### Instruções
- Execute o seguintes comandos para copiar os arquivos
```javascript
    curl https://raw.githubusercontent.com/VivaReal/code-challenge/master/properties.json -o properties.json
```
```javascript
    curl https://raw.githubusercontent.com/VivaReal/code-challenge/master/provinces.json -o provinces.json
```
```javascript
    curl -X POST -d @provinces.json localhost:8080/rest/load --header "Content-Type:application/json"
```
```javascript
    curl -X POST -d @properties.json localhost:8080/rest/load --header "Content-Type:application/json"
```