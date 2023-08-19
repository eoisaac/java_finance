package org.eoisaac.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.UUID;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Data
@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
  @Id @GeneratedValue @UuidGenerator private UUID id;

  @Column(
      name = "created_at",
      nullable = false,
      updatable = false,
      columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @CreationTimestamp
  private Instant createdAt;

  @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
  @UpdateTimestamp
  private Instant updatedAt;
}
