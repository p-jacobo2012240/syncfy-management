package com.syncfy.management.domain;

import lombok.Data;

@Data
public class AuthDtoCreatorDomain {

    private String email;

    private String aud;

    private String iss;

    private String nonce;

    private String picture;
}