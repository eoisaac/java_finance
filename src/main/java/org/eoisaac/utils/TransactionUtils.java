package org.eoisaac.utils;

import java.util.List;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionSummary;
import org.eoisaac.model.entities.TransactionType;

public class TransactionUtils {
  public static TransactionSummary calculateTransactionSummary(List<TransactionEntity> transactions) {
    float totalIncome = calculateTotalPriceByType(transactions, TransactionType.INCOME);
    float totalExpense = calculateTotalPriceByType(transactions, TransactionType.EXPENSE);
    float totalBalance = totalIncome - totalExpense;

    return TransactionSummary.builder()
            .totalIncome(totalIncome)
            .totalExpense(totalExpense)
            .totalBalance(totalBalance)
            .build();
  }

  private static float calculateTotalPriceByType(List<TransactionEntity> transactions, TransactionType type) {
    return transactions.stream()
            .filter(transaction -> transaction.getType() == type)
            .map(TransactionEntity::getValue)
            .reduce(0.0f, Float::sum);
  }

}
