package org.eoisaac.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public BaseModelEntity() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
}
