# java_finance

The project requirements are in `./docs/requirements.pdf`

## Requirements

- Java 8
- Maven 3.6.3
- Docker Compose version v2.20.2

## How to run

- Install the dependencies

    ```bash
    mvn install
    ```

- Start the database

    ```bash
    docker-compose up -d
    ```

- Run the application

    ```bash
    mvn run
    ```
  or
    ```bash
    mvn package
    java -jar target/java_finance-1.0-SNAPSHOT.jar
    ```







