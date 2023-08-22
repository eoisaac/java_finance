package org.eoisaac.controllers;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.eoisaac.model.dao.TransactionDao;
import org.eoisaac.model.entities.CategoryEntity;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionType;

/*
* That class is responsible for controlling the transaction DAO.
* */
public class TransactionController {
  TransactionDao transactionDao; // Transaction DAO

  public TransactionController() { // Constructor
    transactionDao = new TransactionDao(); // Initialize transaction DAO
  }

  public Optional<TransactionEntity> createTransaction(
      String name,
      TransactionType type,
      float value,
      Instant entryDate,
      CategoryEntity category) { // Create transaction
    TransactionEntity newTransaction = // Create new transaction
        TransactionEntity.builder()
            .name(name)
            .type(type)
            .price(value)
            .entryDate(entryDate)
            .category(category)
            .build();
    return transactionDao.create(newTransaction); // Return created transaction
  }

  public boolean deleteTransaction(UUID id) { // Delete transaction

    return transactionDao.delete(id); // Return true if transaction was deleted, else false
  }

  public List<TransactionEntity> getAllTransactions() { // Get all transactions
    return transactionDao.getAll(); // Return all transactions
  }
}
