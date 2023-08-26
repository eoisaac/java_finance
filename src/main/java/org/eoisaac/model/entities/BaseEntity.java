package org.eoisaac.model.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.*;

@Data // Automatically generates toString, equals, hashCode, getters and setters for all fields
@Getter // Automatically generates getters for all fields
@Setter // Automatically generates setters for all fields
@SuperBuilder // Automatically generates builder pattern
@MappedSuperclass // Tells Hibernate to not create a table for this class
@NoArgsConstructor // Automatically generates no-args constructor
@AllArgsConstructor // Automatically generates all-args constructor
public class BaseEntity {
  @Id @GeneratedValue @UuidGenerator
  private UUID id; // Automatically generates a UUID as the primary key

  @Column( // Automatically generates a column for this field
      name = "created_at", // Sets the name of the column
      nullable = false, // Sets the column to not allow null values
      updatable = false, // Sets the column to not be updatable
      columnDefinition =
          "TIMESTAMP WITH TIME ZONE") // Sets the column to be a timestamp with time zone
  @CreationTimestamp // Automatically generates a timestamp when the entity is created
  private Instant createdAt;

  @Column(
      name = "updated_at", // Sets the name of the column
      nullable = false, // Sets the column to not allow null values
      columnDefinition =
          "TIMESTAMP WITH TIME ZONE") // Sets the column to be a timestamp with time zone
  @UpdateTimestamp // Automatically generates a timestamp when the entity is updated
  private Instant updatedAt;
}
