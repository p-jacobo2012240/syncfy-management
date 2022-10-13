package com.syncfy.management.domain;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
public class AlertDtoCreatorDomain {

    private String name;

    private OffsetDateTime creationDate;

    private OffsetDateTime  expiryDate;

    private String type;

    private Boolean isValidForFilter;

    private String auth0_id;
}
