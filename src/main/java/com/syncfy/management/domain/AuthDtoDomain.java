package com.syncfy.management.domain;

import lombok.Data;

@Data
public class AuthDtoDomain {

    private Long id;

    private String email;

    private String aud;

    private String iss;

    private String nonce;

    private String picture;
}
