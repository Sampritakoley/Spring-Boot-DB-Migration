# Spring-Boot-DB-Migration

This project demonstrates how to manage database migrations in a Spring Boot application using Flyway.

## Project Structure

- SpringDbMigration/
- ├── src/
- │ ├── main/
- │ │ ├── java/
- │ │ └── resources/
-
                  -├── db/
-
                         -├── migration/ # Flyway migration files
-
                                    -  └── V1__create-user.sql / 
                                    -  |__ V2__alter-user-email.sql /
                                    -  |__ V3__user-role-mapping.sql /
- │ └── test/
- │ ├── java/
- │ └── resources/
- ├── target/
- ├── pom.xml
- ├── README.md


## Keys
- A migration in Flyway is a change to your database schema or data that is versioned and applied in a specific order.

- A migration script is a SQL file (or other supported format) containing database changes that are executed by Flyway. Each script has a version number and a description.

- Flyway maintains a schema_version table in your database to track which migrations have been applied. This ensures that each migration script is executed exactly once.

*Database migration is crucial for managing changes to our database schema and data structure. Here are the key advantages:*
- Migrations are necessary to ensure data consistency and integrity across different environments (e.g., development, testing, production). They help synchronize schema changes and prevent data loss or corruption during updates.
- Enables version-controlled management of schema evolution through migration scripts.
- Enhances disaster recovery readiness with rollback procedures for database changes.
