# Employee Performance Management System

A Java-based backend application developed using Spring Boot to manage employee information, departments, projects, and performance reviews.

## Features

- Manage employee records
- Create and manage departments
- Manage projects
- Record and retrieve employee performance reviews
- RESTful APIs for CRUD operations
- DTO-based data transfer
- Exception handling for missing records
- Data persistence using Spring Data JPA and Hibernate
- Unit testing support using JUnit and Mockito

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JUnit 5
- Mockito
- JaCoCo

## Project Structure

- `controller/` — REST API controllers
- `dto/` — Data Transfer Objects
- `entity/` — JPA entity classes
- `repository/` — Database access interfaces
- `service/` — Service interfaces
- `serviceimpl/` — Business logic implementations
- `exceptionHandling/` — Custom exceptions and global exception handling
- `src/test/` — Test classes
- `pom.xml` — Maven dependencies and build configuration

## Getting Started

### Prerequisites

- Java 17 or later
- Maven (or the included Maven Wrapper)
- MySQL Server

### Setup

1. Clone the repository.
2. Open the project folder in VS Code or your preferred Java IDE.
3. Create a MySQL database named `epms`.
4. Configure the database connection using environment variables.
5. Install dependencies and run the application.

### Run the Application

Using the Maven Wrapper on Windows:

```bash
mvnw.cmd spring-boot:run
```

The application runs on:

`http://localhost:8080`

## Testing

Run the test suite using:

```bash
mvnw.cmd test
```

JaCoCo is configured to generate test coverage reports during the Maven test lifecycle.

## Purpose

This project demonstrates backend development with Spring Boot, REST API design, database integration, layered architecture, exception handling, and Java unit testing.
