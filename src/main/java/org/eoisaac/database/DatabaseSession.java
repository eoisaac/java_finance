package org.eoisaac.database;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor
public class DatabaseSession {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
//            DatabaseProperties databaseProperties = new DatabaseProperties();
//            Configuration configuration = new Configuration().addProperties(databaseProperties.getProperties());
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            return configuration.buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed: " + e);
            return null;
        }
    }

    public static Session get() {
        return sessionFactory == null ? null : sessionFactory.openSession();
    }

    public static void close(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
