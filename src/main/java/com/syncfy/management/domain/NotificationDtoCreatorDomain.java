package com.syncfy.management.domain;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class NotificationDtoCreatorDomain {

    private String name;

    private OffsetDateTime creationDate;

    private OffsetDateTime  expiryDate;

    private String type;

    private Boolean isValidForFilter;

    private String auth0_id;
}