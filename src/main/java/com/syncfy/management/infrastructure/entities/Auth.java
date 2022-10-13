package com.syncfy.management.infrastructure.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name="tbl_db_auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private Long authId;

    @Column(name = "email")
    private String email;

    @Column(name = "aud")
    private String aud;

    @Column(name = "iss")
    private String iss;

    @Column(name = "nonce")
    private String nonce;

    @Column(name = "picture")
    private String picture;
}
