package com.syncfy.management.infrastructure.entities;

import lombok.Data;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name="tbl_db_notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long notificationId;

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

    @ManyToOne
    @JoinColumn(name = "auth_id")
    private Auth auth;
}