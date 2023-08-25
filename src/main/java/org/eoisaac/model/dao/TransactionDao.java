package org.eoisaac.model.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.eoisaac.tools.database.DatabaseSession;
import org.eoisaac.model.entities.TransactionEntity;
import org.hibernate.Session;

public class TransactionDao {
  public Optional<TransactionEntity> create(TransactionEntity entity) { // Create category
    Session session = null; // Initialize session
    try {
      session = DatabaseSession.get(); // Get session
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
      return Optional.empty(); // Return empty optional
    }
  }

  public TransactionEntity update(TransactionEntity entity) { // Update category
    Session session = null; // Initialize session
    try {
      session = DatabaseSession.get(); // Get session
      if (session != null) { // Check if session is not null
        session.beginTransaction(); // Begin transaction
        session.merge(entity); // Merge entity
        session.getTransaction().commit(); // Commit transaction
        return entity; // Return entity
      } else {
        System.out.println("Session not created");
        return null; // Return null
      }
    } finally {
      DatabaseSession.close(session); // Close session
    }
  }

  public boolean delete(UUID id) { // Delete category
    Session session = null; // Initialize session
    try {
      session = DatabaseSession.get(); // Get session
      if (session != null) { // Check if session is not null
        session.beginTransaction(); // Begin transaction
        session.remove(session.byId(TransactionEntity.class).load(id)); // Remove entity
        session.getTransaction().commit(); // Commit transaction
        return true; // Return true
      } else {
        System.out.println("Session not created");
        return false; // Return false
      }
    } finally {
      DatabaseSession.close(session); // Close session
    }
  }

  public List<TransactionEntity> getAll() { // Get all categories
    Session session = null; // Initialize session
    try {
      session = DatabaseSession.get();
      if (session != null) { // Check if session is not null
        session.beginTransaction(); // Begin transaction
        return session
            .createQuery("from TransactionEntity", TransactionEntity.class)
            .list(); // Return list of categories
      } else {
        System.out.println("Session not created");
        return null; // Return null
      }
    } finally {
      DatabaseSession.close(session); // Close session
    }
  }
}
