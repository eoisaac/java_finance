package org.eoisaac.model.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity // Tells Hibernate to create a table for this class
@Table(name = "categories") // Sets the name of the table
@Getter // Automatically generates getters for all fields
@Setter // Automatically generates setters for all fields
@SuperBuilder // Automatically generates builder pattern
@AllArgsConstructor // Automatically generates all-args constructor
@NoArgsConstructor // Automatically generates no-args constructor
public class CategoryEntity extends BaseEntity { // Extends the BaseEntity class
  @Column(name = "name", // Sets the name of the column
          unique = true,  // Sets the column to be unique
          nullable = false) // Sets the column to not allow null values
  private String name;
}
