# Java Finance

Os requisitos do projeto estão em `./docs/requirements.pdf`

## Requisitos

- Java 8
- Maven 4.0.0
- Docker Compose version v2.20.2

## Como executar

- Inicie o banco de dados

    ```bash
    docker-compose up --build
    ```

### Com Maven

- Instale as dependências do maven

    ```bash
    mvn install
    ```

- Execute a aplicação

    ```bash
    mvn clean compile exec:java -Dexec.mainClass="org.eoisaac.Main"
    ```

### Com Maven wrapper

- Instale as dependências do maven

    ```bash
    ./mvnw install
    ```

- Execute a aplicação

    ```bash
    ./mvnw clean compile exec:java -Dexec.mainClass="org.eoisaac.Main"
    ```

## Autor

<a href="https://eoisaac.vercel.app/" target="_blank">
  <img src ="https://avatars.githubusercontent.com/u/79121397?v=4" style = "border-radius: 50%" width="90" height="90">
  <div>
    <b>Isaac Santiago</b>
  </div>
</a>

<br>

<div  style="display: inline-block">
	<a href="https://twitter.com/eoisaacc" target="_blank"><img src="https://img.shields.io/badge/Twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white" alt="Meu Twitter" height="20"></a>
	<a href="https://instagram.com/eoisaacc" target="_blank"><img src="https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white" alt="Meu Instagram" height="20"></a>
	<a href="https://linkedin.com/in/eoisaac" target="_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Meu LinkedIn" height="20"></a>
	<a href="https://github.com/eoisaac" target="_blank"><img src="https://img.shields.io/badge/GitHub-000000?style=for-the-badge&logo=github&logoColor=white%22" alt="Meu GitHub" height="20"></a>
</div>