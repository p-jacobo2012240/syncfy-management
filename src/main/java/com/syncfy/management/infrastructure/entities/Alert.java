package com.syncfy.management.infrastructure.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name="tbl_db_alert")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alert_id")
    private Long alertId;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private OffsetDateTime creationDate;

    @Column(name = "expiry_date")
    private OffsetDateTime expiryDate;

    @Column(name = "type")
    private String type;

    @Column(name = "is_filter")
    private Boolean isFilter;

    @Column(name = "auth_id")
    private Integer authId;
}
