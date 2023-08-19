package org.eoisaac.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "categories")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity extends BaseEntity {
  @Column(name = "name", unique = true, nullable = false)
  private String name;
}
