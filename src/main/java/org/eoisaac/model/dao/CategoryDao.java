package org.eoisaac.model.dao;

import java.util.List;
import java.util.Optional;
import org.eoisaac.model.entities.CategoryEntity;
import org.eoisaac.tools.database.DBSessionFactory;
import org.hibernate.Session;

public class CategoryDao {

  public Optional<CategoryEntity> create(CategoryEntity entity) { // Create category
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

  public Optional<CategoryEntity> getByName(String name) { // Get category by name
    try (Session session = DBSessionFactory.getSession()) { // Get session using try-with-resources
      if (session != null) { // Check if session is not null
        return session // Return session
            .createQuery(
                "from CategoryEntity where name = :name", CategoryEntity.class) // Create query
            .setParameter("name", name) // Set parameter
            .uniqueResultOptional(); // Return unique result
      } else {
        System.out.println("Session not created");
        return Optional.empty(); // Return empty optional
      }
    }
  }

  public List<CategoryEntity> getAll() { // Get all categories
    try (Session session = DBSessionFactory.getSession()) { // Get session using try-with-resources
      if (session != null) { // Check if session is not null
        return session
            .createQuery("from CategoryEntity", CategoryEntity.class)
            .list(); // Return list
      } else {
        System.out.println("Session not created");
        return null; // or return an empty list
      }
    }
  }
}
