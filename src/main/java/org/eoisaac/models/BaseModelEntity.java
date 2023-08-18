//package org.eoisaac.models;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.UuidGenerator;
//
//import java.time.Instant;
//import java.util.UUID;
//
//@Data
//@MappedSuperclass
//public class BaseModelEntity {
//    @Id
//    @GeneratedValue
//    @UuidGenerator
//    private UUID id;
//
//    @Column(name = "created_at")
//    private Instant createdAt;
//
//    @Column(name = "updated_at")
//    private Instant updatedAt;
//
//    public BaseModelEntity() {
//        this.createdAt = Instant.now();
//        this.updatedAt = Instant.now();
//    }
//}
