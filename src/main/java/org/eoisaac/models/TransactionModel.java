package org.eoisaac.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Entity
@Table(name = "transactions")
@Getter
@Setter
public class TransactionModel extends BaseModelEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "value")
    private Float value;

    @Column(name = "entry_date")
    private Instant entryDate;

}
