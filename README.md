# Spring-Boot-DB-Migration

This project demonstrates how to manage database migrations in a Spring Boot application using Flyway.

## Project Structure

- SpringDbMigration/
- ├── src/
- │ ├── main/
- │ │ ├── java/
- │ │ └── resources/
- │ │    ├── db/
- │ │       ├── migration/ # Flyway migration files
- │ │          └── V1__create-user.sql / 
- | |          |__ V2__alter-user-email.sql /
- | |          |__ V3__user-role-mapping.sql /
- │ └── test/
- │ ├── java/
- │ └── resources/
- ├── target/
- ├── pom.xml
- ├── README.md
