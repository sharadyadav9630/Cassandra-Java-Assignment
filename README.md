## Prerequisites
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Cassandra](https://cassandra.apache.org/)


## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)
- cqlsh (cassandra query language shell) - for monitoring stored data

###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-cassandra-crud**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory

Run jar file from below path with given command
> **```java -jar ~/path-to-cassandra-java-assignment/target/cassandra-java-assignment-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `CassandraJavaAssignment.java` as spring boot application.

---
### For API document using OpenAPI UI

> http://localhost:8080/swagger-ui-custom.html