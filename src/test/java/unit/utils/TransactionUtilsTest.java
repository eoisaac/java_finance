package unit.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionSummary;
import org.eoisaac.model.entities.TransactionType;
import org.eoisaac.utils.TransactionUtils;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TransactionUtilsTest {
  private final List<TransactionEntity> transactions = new ArrayList<>();
  private float expectedTotalIncome;
  private float expectedTotalExpense;
  private float expectedTotalBalance;

  @BeforeEach
  public void setup() {
    createTransactions();
    expectedTotalBalance = expectedTotalIncome - expectedTotalExpense;
  }

  @AfterEach
  public void tearDown() {
    transactions.clear();
  }

  private void createTransactions() {
    int NUMBER_OF_TRANSACTIONS = 10;
    for (int i = 0; i < NUMBER_OF_TRANSACTIONS; i++) {
      float randomPrice = (float) Math.random() * 100;
      TransactionType type = i % 2 == 0 ? TransactionType.INCOME : TransactionType.EXPENSE;

      if (type == TransactionType.INCOME) {
        expectedTotalIncome += randomPrice;
      } else {
        expectedTotalExpense += randomPrice;
      }

      TransactionEntity transaction =
          TransactionEntity.builder()
              .id(UUID.randomUUID())
              .name(String.format("Test transaction %d", i))
              .price(randomPrice)
              .type(type)
              .build();
      transactions.add(transaction);
    }
  }

  @Test
  public void createTransactionsSummary() {
    TransactionSummary summary = TransactionUtils.calculateTransactionSummary(transactions);

    assertNotNull("Transaction summary should not be null", summary);
    assertEquals(
        "Transaction summary total income should be the same as the expected total income",
        expectedTotalIncome,
        summary.getTotalIncome(),
        0.0f);
    assertEquals(
        "Transaction summary total expense should be the same as the expected total expense",
        expectedTotalExpense,
        summary.getTotalExpense(),
        0.0f);
    assertEquals(
        "Transaction summary total balance should be the same as the expected total balance",
        expectedTotalBalance,
        summary.getTotalBalance(),
        0.0f);
  }
}
