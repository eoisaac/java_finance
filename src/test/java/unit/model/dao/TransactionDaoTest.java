package unit.model.dao;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.eoisaac.model.dao.CategoryDao;
import org.eoisaac.model.dao.TransactionDao;
import org.eoisaac.model.entities.CategoryEntity;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionType;
import org.junit.Test;

public class TransactionDaoTest {

  private final CategoryDao categoryDao = new CategoryDao();
  private final TransactionDao transactionDao = new TransactionDao();

  @Test
  public void getAllTransactions() {
    List<TransactionEntity> transactions = transactionDao.getAll();

    assertNotNull("Categories should not be null", transactions);
    assertFalse("Categories should not be empty", transactions.isEmpty());

    int TOTAL_DB_TRANSACTIONS = 8; // Based in the resources/data/seed.sql file
    assertEquals("Categories size should be 8", TOTAL_DB_TRANSACTIONS, transactions.size());
  }

  @Test
  public void createTransaction() {
    List<CategoryEntity> categories = categoryDao.getAll();
    CategoryEntity category = categories.get(0);

    TransactionEntity transaction =
        TransactionEntity.builder()
            .category(category)
            .price(100.0F)
            .name("Test expense transaction")
            .entryDate(Instant.now())
            .type(TransactionType.EXPENSE)
            .category(category)
            .build();

    Optional<TransactionEntity> createdTransaction = transactionDao.create(transaction);

    assertTrue(createdTransaction.isPresent());

    assertNotNull("Transaction id should not be null", createdTransaction.get().getId());
    assertNotNull(
        "Transaction create_at should not be null", createdTransaction.get().getCreatedAt());
    assertNotNull(
        "Transaction update_at should not be null", createdTransaction.get().getUpdatedAt());

    assertEquals(
        "Transaction name should be Test expense transaction",
        "Test expense transaction",
        createdTransaction.get().getName());
    assertEquals(
        "Transaction price should be 100.0", 100.0F, createdTransaction.get().getPrice(), 0.0F);
    assertEquals(
        "Transaction type should be EXPENSE",
        TransactionType.EXPENSE,
        createdTransaction.get().getType());
    assertEquals(
        "Transaction category should be the same as the created",
        category,
        createdTransaction.get().getCategory());
  }

  @Test
  public void deleteTransaction() {
    List<TransactionEntity> transactions = transactionDao.getAll();
    TransactionEntity transaction = transactions.get(0);

    boolean deleted = transactionDao.delete(transaction.getId());
    assertTrue(deleted);
  }
}
