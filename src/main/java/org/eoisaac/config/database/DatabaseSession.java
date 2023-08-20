package org.eoisaac.config.database;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor
public class DatabaseSession {
  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    try {
      Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // Get configuration from hibernate.cfg.xml
      return configuration.buildSessionFactory(); // Create session factory from configuration
    } catch (Throwable e) {
      System.err.println("Initial SessionFactory creation failed: " + e);
      return null;
    }
  }

  public static Session get() {
    return sessionFactory == null ? null : sessionFactory.openSession(); // Open session from session factory
  }

  public static void close(Session session) {
    if (session != null && session.isOpen()) { // Close session if it is open
      session.close(); // Close session
    }
  }

  public static void closeSessionFactory() {
    if (sessionFactory != null && !sessionFactory.isClosed()) { // Close session factory if it is open
      sessionFactory.close(); // Close session factory
    }
  }
}
