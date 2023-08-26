package org.eoisaac.tools.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * That class is responsible for creating and closing the database session factory and session.
 * It uses the SessionFactory class to create the session factory, and the Session class to create the session.
 * So, it has a method to create the session factory, a method to get the session, a method to close the session,
 * and a method to close the session factory.
 * */

public class DBSessionFactory {
  private static final SessionFactory sessionFactory = buildSessionFactory(); // Creates the session factory

  public static SessionFactory buildSessionFactory() { // Creates the session factory
    try {
      Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // Get the configuration from the hibernate.cfg.xml file
      return configuration.buildSessionFactory(); // Builds the session factory
    } catch (Throwable e) {
      System.err.println("Initial SessionFactory creation failed: " + e);
      throw new ExceptionInInitializerError(e);
    }
  }

  public static Session getSession() {
    return sessionFactory.openSession();
  } // Gets the database session

  public static void closeSession(Session session) { // Closes the database session
    if (session != null && session.isOpen()) { // Checks if the session is not null and is open
      session.close(); // Closes the session
    }
  }

}
