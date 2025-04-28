# Tomcat

## Spring Boot集成Tomcat

```plantuml
@startuml
actor User
entity "Spring Boot App" as App
entity "Tomcat Embedded Server" as Tomcat
entity "HTTP Request" as Request
entity "HTTP Response" as Response

User -> Request: Send HTTP Request
Request -> App: Forward Request
App -> Tomcat: Pass Request to Tomcat
Tomcat -> App: Process and Return Response
App -> Response: Return HTTP Response
Response -> User: Send Response to User

@enduml

```

通过spring-boot-starter-web依赖集成Tomcat

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

在spring-boot-starter-web中依赖了spring-boot-starter-tomcat

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
    <version>${version}</version>
    <scope>compile</scope>
</dependency>
```

