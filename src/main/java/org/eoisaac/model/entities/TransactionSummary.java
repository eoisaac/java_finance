package org.eoisaac.model.entities;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class TransactionSummary {
  private final float totalIncome;
  private final float totalExpense;
  private final float totalBalance;
}
