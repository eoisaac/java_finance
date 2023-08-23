package unit.model.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;
import org.eoisaac.model.entities.TransactionEntity;
import org.eoisaac.model.entities.TransactionType;
import org.junit.Test;

public class TransactionEntityTest {
    @Test
    public void createTransactionEntity() {
        TransactionEntity transaction = new TransactionEntity();

        assertNotNull("Transaction should not be null", transaction);
    }

    @Test
    public void createTransactionEntityBuilder() {
        UUID id = UUID.randomUUID();
        String name = "Test transaction";

        TransactionEntity transaction = TransactionEntity.builder()
            .id(id)
                .name(name)
                .price(100.0f)
                .type(TransactionType.INCOME)
            .build();

        assertNotNull("Transaction should not be null", transaction);
        assertEquals("Transaction id should be the same as the one passed to the builder",
                id, transaction.getId());
        assertEquals("Transaction name should be the same as the one passed to the builder",
                name, transaction.getName());
    }
}
