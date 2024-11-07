# Employee Management Spring Boot Project

## Overview

This is a Spring Boot project for managing employees, with basic GET and CREATE operations. The primary purpose of this
project is to understand how to use Testcontainers after Spring Boot version 3.1.0. Testcontainer config class is
created and implemented in
the repository test and employee controller integration test classes to manage the MySQL database during testing.
Testcontainer config class is
also used in running application locally

## Features

- Manage employee records with basic CRUD operations.
- Integration with MySQL database using Testcontainer.
- Unit and integration tests using JUnit and Testcontainers.

## Project Setup

### Prerequisites

- Java 17
- Gradle
- MySQL Database
- Docker Desktop or Docker Engine (for testcontainers)

### Dependencies

The following dependencies are used in this project:

- Spring Web
- Spring Data JPA
- MySQL Driver
- JUnit 5
- Testcontainers

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/employee-management.git
    ```
2. Navigate to the project directory:
    ```sh
    cd employee-management
    ```
3. Update `application.properties` with your MySQL database configuration:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
    spring.datasource.username=root
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    ```

4. Build and run the project using Gradle (if mysql instance connection url is known):
    ```sh
    ./gradlew bootRun
    ```
5. (Optional) To run project locally using testcontainer
    ```sh
    ./gradlew bootTestRun 
    ``` 

## Testing

The project includes unit tests or controller and service classes, and integration tests for the repository and
controller classes. Testcontainers are used to manage the MySQL database during tests.

### Testcontainers Setup

In the `EmployeeRepositoryTest` and `EmployeeControllerIntegrationTest` classes, Testcontainers are used to spin up a
MySQL container for testing purposes. This ensures a consistent and isolated test environment.

### Running Tests

To run the tests, use the following command:

```sh
./gradlew test
```

### cURL to test via postman or cmd or bash

    curl --location 'http://localhost:8080/employees' \
    --header 'Content-Type: application/json' \
    --data '{
    "name": "Shreya Ghoshal",
    "department": "Business Analyst",
    "salary": "50000"
    }'

```
curl --location 'http://localhost:8080/employees'
```

## References

* [Spring Boot Application Testing and Development with Testcontainers](https://www.docker.com/blog/spring-boot-application-testing-and-development-with-testcontainers/)
* [Getting started with Testcontainers in a Java Spring Boot Project](https://testcontainers.com/guides/testing-spring-boot-rest-api-using-testcontainers/)
* [Simple local development with Testcontainers Desktop
  ](https://testcontainers.com/guides/simple-local-development-with-testcontainers-desktop/)
* [java-local-development-workshop](https://github.com/testcontainers/java-local-development-workshop/blob/main/step-3-local-development-environment.md)