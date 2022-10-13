package com.syncfy.management.domain;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
public class AlertDtoDomain {

    private Long id;

    private String name;

    private OffsetDateTime creationDate;

    private OffsetDateTime expiryDate;

    private String type;

    private Boolean isValidForFilter;

    private AuthDtoDomain domain;
}