package com.syncfy.management.domain;

import lombok.Data;

import java.util.Date;

@Data
public class AlertDtoCreatorDomain {

    private String name;

    private Date creationDate;

    private Date expiryDate;

    private String type;

    private Boolean isValidForFilter;

    private String auth0_id;
}
