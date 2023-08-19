package org.eoisaac;

import java.time.Instant;
import java.util.Optional;
import org.eoisaac.dao.TransactionDao;
import org.eoisaac.entities.TransactionEntity;
import org.eoisaac.entities.TransactionType;

public class Main {
  public static void main(String[] args) {

    TransactionDao transactionDao = new TransactionDao();

    TransactionEntity newTransaction =
        TransactionEntity.builder()
            .name("Sample Transaction 2")
            .type(TransactionType.EXPENSE)
            .value(100.0f)
            .entryDate(Instant.now())
            .build();

    Optional<TransactionEntity> created = transactionDao.create(newTransaction);
    if (created.isPresent()) {
      TransactionEntity createdTransaction = created.get();
      createdTransaction.setName("Updated Transaction Name");
      TransactionEntity updatedTransaction = transactionDao.update(createdTransaction);
      if (updatedTransaction != null) {
        System.out.println("Transaction updated successfully: " + updatedTransaction);
      } else {
        System.out.println("Failed to update transaction.");
      }
    } else {
      System.out.println("Failed to create transaction.");
    }
  }
}
