## Project Description.

I have not used any Third party API to get longitude and latitude due to security reasons but created my own "**FindLocation.java**" class which returns longitude and latitude while passing locationName to it.

I have hardcoded below mentioned locationName is "**FindLocation.java**" that you can refer to configure **scan_location** table while calling  "ScanLocationConroller" Post method.

**LocationName: Glasgow,Edinburgh,Aberdeen,Hamilton,Falkirk,Cambuslang,India,Chennai,Nepal,India Ocean**

To Configure **scan_result** table please use below mentioned birdId which are the primary key in bird table.

**birdId: f759b924-34cb-4467-9cd9-a3ce62c1c8d0, 7bff64e7-fb12-420b-a2b5-bd966bb31588, 673f1001-07f0-4493-8550-3d015e96e48a, 74fba515-bbb3-4146-b696-79618ceaa270, cd05e2f0-e4f5-4ba9-8b96-43e3f0570716, c1f78ad2-0920-4e15-80c7-c9d3a8548391, ab75a3f9-1f32-4b28-8b82-f9478bb811ea, 6e2f21f5-ddc3-4c46-8508-1ec5a83c2e87, 1903e880-a9ff-4e47-86b1-025fb6ac08a4, fd9b13db-d9cb-466d-8ef6-ff7f5cabef2b**

To Run The Application : Import application in Intellij and right click on "**CasandraJavaAssignment.java**" class and click Run. After the server gets started please copy **http://localhost:8080/swagger-ui-custom.html** into the browser.

When application get started data in the **bird table** will be inserted by application so never given any DDL statement in the CQLStatements.md file.


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
_GOTO >_ **~/absolute-path-to-directory/Cassandra-java-assignment**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory

Run jar file from below path with given command
> **```java -jar ~/path-to-Cassandra-java-assignment/target/Cassandra-java-assignment-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `CassandraJavaAssignment.java` as spring boot application.

---
### For API document using OpenAPI UI

> http://localhost:8080/swagger-ui-custom.html
