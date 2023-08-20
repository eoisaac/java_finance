package org.eoisaac.model.entities;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter // Automatically generates getters for all fields
@SuperBuilder // Automatically generates builder pattern
public class TransactionSummary {
  private final float totalIncome; // Total value of all income transactions price
  private final float totalExpense; // Total value of all expense transactions price
  private final float totalBalance; // Difference between totalIncome and totalExpense
}
