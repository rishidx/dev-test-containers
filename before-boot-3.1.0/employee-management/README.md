# Employee Management Spring Boot Project

## Overview

This is a Spring Boot project for managing employees, with basic GET and CREATE operations. The primary purpose of this
project is to understand how to use Testcontainers prior to Spring Boot version 3.1.0. Testcontainers are implemented in
the repository test and employee controller integration test classes to manage the MySQL database during testing.

## Features

- Manage employee records with basic CRUD operations.
- Integration with MySQL database.
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

4. Build and run the project using Gradle:
    ```sh
    ./gradlew bootRun
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
