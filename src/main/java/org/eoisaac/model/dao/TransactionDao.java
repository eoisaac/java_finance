package org.eoisaac.model.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.eoisaac.config.database.DatabaseSession;
import org.eoisaac.model.entities.TransactionEntity;
import org.hibernate.Session;

public class TransactionDao {
  public Optional<TransactionEntity> create(TransactionEntity entity) {
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

  public TransactionEntity update(TransactionEntity entity) {
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

  public Boolean delete(UUID id) {
    Session session = null;
    try {
      session = DatabaseSession.get();
      if (session != null) {
        session.beginTransaction();
        session.remove( session.byId(TransactionEntity.class).load(id));
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

  public List<TransactionEntity> getAll() {
    Session session = null;
    try {
      session = DatabaseSession.get();
      if (session != null) {
        session.beginTransaction();
        return session.createQuery("from TransactionEntity", TransactionEntity.class).list();
      } else {
        System.out.println("Session not created");
        return null;
      }
    } finally {
      DatabaseSession.close(session);
    }
  }

}
