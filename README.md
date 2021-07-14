# Java Spring Boot

## Table of Contents
* [General info](#general-info) 
* [Technologies](#technologies) 
* [Setup](#setup)
* [Extra information](#Extra)

------------
## General info

In this course i learned more about Spring boot. In the files you will find only the examples of each topic that we saw in the course, it's not a project but there are a clearly examples of each topic and how to use it with simple sentence, like IoC, querymethods, JPQL, API rest, transactional, and more topics specificated in *Things learned below*.

------------
## Technologies

>- JDK11 (requieres installation)
>- IntelliJ IDEA (requieres installation)
>- Postman (requieres installation)
>. Spring initializr

## Dependencies:

>- Spring Boot Dev Tools 
>- Spring Boot Starter Web
>- H2 Database

------------
## Setup
This project was made on a Windows 10 OS.

### IntelliJ IDEA 
- Go to https://www.jetbrains.com/idea/download/ and download the Community version

### JDK
- Go to https://www.oracle.com/java/technologies/javase-jdk11-downloads.html and download the according version to your OS.
- Complete the installation process. 

### PostMan
- Go to https://www.postman.com/downloads/ and click on the download the app button.
- Complete the installation process.

###  Sring Initializr
- Go to https://start.spring.io/ and configure the project with java 11 and maven.
- Click on the generete button and download the file. This file contains the Java Project which is going to be opened with Intellij IDEA.
- Extract the file.


*Within Intellij IDEA*


### Spring Boot Dev Tools 
- Copy the next code and insert it into the pom.xml file in the dependencies part of the code.
- `<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
<optional>true</optional>
</dependency>`


### Spring Boot Starter Web
- Copy the next code and insert it into the pom.xml file in the dependencies part of the code.
- `<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>`

### H2 Database
- Copy the next code and insert it into the pom.xml file in the dependencies part of the code.
- `<dependency>
<groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
<version>1.4.200</version>
<scope>runtime</scope>
</dependency>`

------------
## Extra

>- Springboot
>- characteristics of SpringBoot
>- Dependency
>- IoC and dependencies inyection
>- Autoconfiguration and runtime
>- anotations for indicate dependencies in SpringBoot
>- port and path change
>- use of properties and values
>- POJOs
>- What log is and how to use it
>- Modelated with JPA entities
>- datasource configuration
>- JPArepository
>- JPQL as language
>- Query methods
>- transactional anotations
>- Rollback with transactional
>- CRUD with Rest structure (methods create, update and delete)
>- API REST
>- Pagination with springboot

------------
### commands that i learned
|  Command | Function  |
| ------------ | ------------ |
| @Springbootapplication | Tells Spring Boot that a class manages the app   |
| @Entitiy | Use in java class that it is representing a table in the database   |
| @table  | Receives the name of the table to which our class is mapping   |
| @column  | Used when the name of our column is different from the name of the attribute of our table   |
| @id  | Represents the primary key of the table |
| @GenerateValue  | Automatically generate values for the primary keys   |
| @OneToMany @ManyToOne  | Represent existing relationships in tables but represented in classes   |
| @Query    | Used to make native queries   |
| @Repository   | Tells the class that it interacts with the database |
| @Component   | Indicates a class is a spring component  |
| @Service   | Indicates that a class is a business logic service  |
| @RestController   | Tells spring that a class will be a controller of a rest API |
| @RequestMapping | It indicates in which path it will accept the requests that we make |
| @PathVariable | Is to specify the path that you will put in the URL |
| @GetMapping    | To obtain information  |
| @Postmapping  | To save or update information  |
| @Deletemapping | To delete information |
| CrudRepository methods | save(), delete(), update() |
| @Qualifier | Tells which dependency is going to be inyected |
| @Value | Brings values previusly genereted in properties files |
| @Transactional | Makes rollback when a simple operation inside fails ignonring the correct operations to the DB |
| @Bean | Object that is instantiated, assembled, and managed by a Spring IoC container |
