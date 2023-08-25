package unit.tools.database;

import static org.junit.jupiter.api.Assertions.*;

import org.eoisaac.tools.database.DBSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DBSessionFactoryTest {

  private SessionFactory sessionFactory;
  private Session session;

  @BeforeEach
  public void setup() {
    sessionFactory = DBSessionFactory.buildSessionFactory();
    session = sessionFactory.openSession();
  }

  @AfterEach
  public void tearDown() {
    if (session != null && session.isOpen()) {
      session.close();
    }
    if (sessionFactory != null && !sessionFactory.isClosed()) {
      sessionFactory.close();
    }
  }

  @Test
  public void testSessionFactoryCreation() {
    assertNotNull(sessionFactory);
  }

  @Test
  public void testSessionCreation() {
    assertNotNull(session);
  }
}
