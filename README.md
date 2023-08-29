# java_finance

The project requirements are in `./docs/requirements.pdf`

## Requirements

- Java 8
- Maven 4.0.0
- Docker Compose version v2.20.2

## How to run

- Install the maven dependencies

    ```bash
    mvn install
    ```

- Start the database

    ```bash
    docker-compose up --build
    ```

- Run the application

    ```bash
    mvn clean compile exec:java -Dexec.mainClass="org.eoisaac.Main"
    ```








