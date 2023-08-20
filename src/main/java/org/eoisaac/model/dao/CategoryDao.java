package org.eoisaac.model.dao;

import java.util.List;
import java.util.Optional;
import org.eoisaac.config.database.DatabaseSession;
import org.eoisaac.model.entities.CategoryEntity;
import org.hibernate.Session;

public class CategoryDao {

  public Optional<CategoryEntity> create(CategoryEntity entity) {
    try (Session session = DatabaseSession.get()) {
      if (session != null) {
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        return Optional.of(entity);
      } else {
        System.out.println("Session not created");
        return Optional.empty();
      }
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  public CategoryEntity update(CategoryEntity entity) {
    Session session = null;
    try {
      session = DatabaseSession.get();
      if (session != null) {
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        return entity;
      } else {
        System.out.println("Session not created");
        return null;
      }
    } finally {
      DatabaseSession.close(session);
    }
  }

  public boolean delete(CategoryEntity entity) {
    Session session = null;
    try {
      session = DatabaseSession.get();
      if (session != null) {
        session.beginTransaction();
        session.remove(entity);
        session.getTransaction().commit();
        return true;
      } else {
        System.out.println("Session not created");
        return false;
      }
    } finally {
      DatabaseSession.close(session);
    }
  }

  public Optional<CategoryEntity> getByName(String name) {
    Session session = null;
    try {
      session = DatabaseSession.get();
      if (session != null) {
        return session
            .createQuery("from CategoryEntity where name = :name", CategoryEntity.class)
            .setParameter("name", name)
            .uniqueResultOptional();
      } else {
        System.out.println("Session not created");
        return Optional.empty();
      }
    } finally {
      DatabaseSession.close(session);
    }
  }

  public List<CategoryEntity> getAll() {
    Session session = null;
    try {
      session = DatabaseSession.get();
      if (session != null) {
        return session.createQuery("from CategoryEntity", CategoryEntity.class).list();
      } else {
        System.out.println("Session not created");
        return null; // or return an empty list
      }
    } finally {
      DatabaseSession.close(session);
    }
  }
}
