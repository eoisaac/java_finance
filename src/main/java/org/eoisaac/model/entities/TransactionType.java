package org.eoisaac.model.entities;

import lombok.*;

@Getter // Automatically generates getters for all fields
@AllArgsConstructor // Automatically generates all-args constructor
public enum TransactionType {
  INCOME, // Income transaction type
  EXPENSE // Expense transaction type
}
