package org.eoisaac.utils;

import java.util.List;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionSummary;
import org.eoisaac.model.entities.TransactionType;

/*
 * That class is responsible for calculating the transaction summary. It receives a list of transactions, and returns a
 * transaction summary. The transaction summary contains the total income, the total expense, and the total balance.
 * To calculate the values, the method uses the calculateTotalPriceByType method, which receives a list of transactions,
 * and a transaction type. It filters the transactions by type, maps the transactions to their price, and sums the prices.
 * */

public class TransactionUtils { // Utility class for transaction calculations
  public static TransactionSummary calculateTransactionSummary(
      List<TransactionEntity> transactions) { // Calculates the transaction summary
    float totalIncome =
        calculateTotalPriceByType(
            transactions, TransactionType.INCOME); // Calculates the total income
    float totalExpense =
        calculateTotalPriceByType(
            transactions, TransactionType.EXPENSE); // Calculates the total expense
    float totalBalance = totalIncome - totalExpense; // Calculates the total balance

    return TransactionSummary.builder() // Returns the transaction summary
        .totalIncome(totalIncome)
        .totalExpense(totalExpense)
        .totalBalance(totalBalance)
        .build();
  }

  private static float calculateTotalPriceByType(
      List<TransactionEntity> transactions,
      TransactionType type) { // Calculates the total price of a transaction type
    return transactions.stream() // Returns the total price of a transaction type
        .filter(transaction -> transaction.getType() == type) // Filters the transactions by type
        .map(TransactionEntity::getPrice) // Maps the transactions to their price
        .reduce(0.0f, Float::sum); // Sums the prices
  }
}
