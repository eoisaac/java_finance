package org.eoisaac.model.entities;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity // Tells Hibernate to create a table for this class
@Table(name = "transactions") // Sets the name of the table
@Getter // Automatically generates getters for all fields
@Setter // Automatically generates setters for all fields
@SuperBuilder // Automatically generates builder pattern
@AllArgsConstructor // Automatically generates all-args constructor
@NoArgsConstructor // Automatically generates no-args constructor
public class TransactionEntity extends BaseEntity { // Extends the BaseEntity class
  @Column(name = "name") // Sets the name of the column
  private String name;

  @Column(name = "type") // Sets the name of the column
  @Enumerated(EnumType.STRING) // Sets the column to be an enumerated type (EXPENSE or INCOME
  private TransactionType type;

  @Column(name = "price") // Sets the name of the column
  private Float price;

  @Column(name = "entry_date") // Sets the name of the column
  private Instant entryDate;

  @ManyToOne(fetch = FetchType.EAGER) // Sets the relationship to be many-to-one
  @JoinColumn(name = "category_id") // Sets the name of the column
  private CategoryEntity category;
}
