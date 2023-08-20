package org.eoisaac.controllers;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.eoisaac.model.dao.TransactionDao;
import org.eoisaac.model.entities.CategoryEntity;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionType;

public class TransactionController {
  TransactionDao transactionDao;

  public TransactionController() {
    transactionDao = new TransactionDao();
  }

  public Optional<TransactionEntity> createTransaction(
      String name, TransactionType type, float value, Instant entryDate, CategoryEntity category) {
    TransactionEntity newTransaction =
        TransactionEntity.builder()
            .name(name)
            .type(type)
            .value(value)
            .entryDate(entryDate)
            .category(category)
            .build();
    return transactionDao.create(newTransaction);
  }

  public List<TransactionEntity> getAllTransactions() {
    return transactionDao.getAll();
  }
}
