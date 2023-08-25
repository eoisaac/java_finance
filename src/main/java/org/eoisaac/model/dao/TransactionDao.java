package org.eoisaac.model.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.tools.database.DBSessionFactory;
import org.hibernate.Session;

public class TransactionDao {
  public Optional<TransactionEntity> create(TransactionEntity entity) { // Create category
    try (Session session = DBSessionFactory.getSession()) { // Get session using try-with-resources
      if (session != null) { // Check if session is not null
        session.beginTransaction(); // Begin transaction
        session.persist(entity); // Persist entity
        session.getTransaction().commit(); // Commit transaction
        return Optional.of(entity); // Return entity
      } else {
        System.out.println("Session not created");
        return Optional.empty(); // Return empty optional
      }
    } catch (Exception e) {
      e.printStackTrace();
      return Optional.empty(); // Return empty optional
    }
  }

  public TransactionEntity update(TransactionEntity entity) { // Update category
    try (Session session = DBSessionFactory.getSession()) { // Get session using try-with-resources
      if (session != null) { // Check if session is not null
        session.beginTransaction(); // Begin transaction
        session.merge(entity); // Merge entity
        session.getTransaction().commit(); // Commit transaction
        return entity; // Return entity
      } else {
        System.out.println("Session not created");
        return null; // Return null
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null; // Return null
    }
  }

  public boolean delete(UUID id) { // Delete category
    try (Session session = DBSessionFactory.getSession()) { // Get session using try-with-resources
      if (session != null) { // Check if session is not null
        session.beginTransaction(); // Begin transaction
        TransactionEntity entity = session.byId(TransactionEntity.class).load(id);
        if (entity != null) {
          session.remove(entity); // Remove entity
          session.getTransaction().commit(); // Commit transaction
          return true; // Return true
        } else {
          System.out.println("Entity not found");
          return false; // Return false
        }
      } else {
        System.out.println("Session not created");
        return false; // Return false
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false; // Return false
    }
  }

  public List<TransactionEntity> getAll() { // Get all transactions
    try (Session session = DBSessionFactory.getSession()) { // Get session using try-with-resources
      if (session != null) { // Check if session is not null
        return session
                .createQuery("from TransactionEntity", TransactionEntity.class)
                .list(); // Return list of transactions
      } else {
        System.out.println("Session not created");
        return null; // Return null
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null; // Return null
    }
  }
}
