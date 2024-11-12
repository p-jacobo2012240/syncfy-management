package com.syncfy.management.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.YesNoConverter;

import java.time.OffsetDateTime;

@Data
@Entity
@Table(name="tbl_db_auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id", unique = true)
    private Long authId;

    @Column(name = "sub", nullable = false, unique = true) // mapping to 0Auth2 identifier
    private String sub;

    @Column(name = "createAt", updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updatedAt")
    private OffsetDateTime updatedAt;

    @Column(name = "isActive")
    @Convert(converter = YesNoConverter.class)
    private Boolean isActive;

    @PrePersist
    protected void onCreate() {
        createdAt = OffsetDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = OffsetDateTime.now();
    }
}
