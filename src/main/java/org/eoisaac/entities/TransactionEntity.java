package org.eoisaac.entities;

import jakarta.persistence.*;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity extends BaseEntity {
  @Column(name = "name")
  private String name;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private TransactionType type;

  @Column(name = "value")
  private Float value;

  @Column(name = "entry_date")
  private Instant entryDate;

  @Column(name = "registered_at")
  private Instant registeredAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private CategoryEntity category;
}
