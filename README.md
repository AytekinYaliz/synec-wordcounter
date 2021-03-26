# synec-wordcounter

- clone or download the repository on to your local machine
- from a terminal run the following command
```
  ./mvnw clean install
  ./mvnw spring-boot:run -pl wordcounter-service 
```
The application:
- will run on http://localhost:8080

- [POST] http://localhost:8080/api/v1/wordcounter/flower
- [GET] http://localhost:8080/api/v1/wordcounter/flower

PS:
Implementation for the Translator class has been included here to be able to run the application. Normally, it needs to be added only a simple interface as the following. 

```
 public interface Translator {
     String translate(String word);
 }
```