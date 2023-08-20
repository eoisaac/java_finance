package org.eoisaac;


import javax.swing.*;
import org.eoisaac.model.dao.TransactionDao;
import org.eoisaac.views.AppFrame;

public class Main {
  public static void main(String[] args) {
    TransactionDao transactionDao = new TransactionDao();
//
//    TransactionEntity newTransaction =
//            TransactionEntity.builder()
//                    .name("Sample Transaction 2")
//                    .type(TransactionType.EXPENSE)
//                    .value(100.0f)
//                    .entryDate(Instant.now())
//                    .build();
//
//    Optional<TransactionEntity> created = transactionDao.create(newTransaction);
//    if (created.isPresent()) {
//      TransactionEntity createdTransaction = created.get();
//      createdTransaction.setName("Updated Transaction Name");
//      TransactionEntity updatedTransaction = transactionDao.update(createdTransaction);
//      if (updatedTransaction != null) {
//        System.out.println("Transaction updated successfully: " + updatedTransaction.getId());

//        boolean deleted = transactionDao.delete(updatedTransaction);
//        if (deleted) {
//          System.out.println("Transaction deleted successfully.");
//        } else {
//          System.out.println("Failed to delete transaction.");
//        }

//      } else {
//        System.out.println("Failed to update transaction.");
//      }
//    } else {
//      System.out.println("Failed to create transaction.");
//    }

    SwingUtilities.invokeLater(() -> {
      AppFrame appFrame = new AppFrame();
      appFrame.setVisible(true);
    });
  }
}

