# Java Finance

The project requirements are in `./docs/requirements.pdf`

## Requirements

- Java 8
- Maven 4.0.0
- Docker Compose version v2.20.2

## How to run

- Start the database

    ```bash
    docker-compose up --build
    ```

### With Maven

- Install the maven dependencies

    ```bash
    mvn install
    ```

- Run the application

    ```bash
    mvn clean compile exec:java -Dexec.mainClass="org.eoisaac.Main"
    ```

### With Maven wrapper

- Install the maven dependencies

    ```bash
    ./mvnw install
    ```

- Run the application

    ```bash
    ./mvnw clean compile exec:java -Dexec.mainClass="org.eoisaac.Main"
    ```
