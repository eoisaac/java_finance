package org.eoisaac.database;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Properties;

@Getter
public class DatabaseProperties {

    private final Properties properties = new Properties();

    public DatabaseProperties() {
        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/java_finance_db");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "postgres");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
    }
}
