package com.syncfy.management.domain;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class NotificationDtoDomain {

    private Long id;

    private String name;

    private OffsetDateTime creationDate;

    private OffsetDateTime expiryDate;

    private String type;

    private Boolean isValidForFilter;

    private AuthDtoDomain auth;
}
