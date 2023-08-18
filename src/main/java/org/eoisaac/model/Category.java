package org.eoisaac.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "categories")
@Getter
@Setter
@SuperBuilder
public class Category extends Base {
    @Column(name = "name", unique = true, nullable = false)
    private String name;
}