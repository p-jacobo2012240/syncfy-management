package com.syncfy.management.domain;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class AuthDtoDomain {
    private String oAuthId;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Boolean isActive;
    private String customUserData;

    @Override
    public String toString() {
        return "AuthDtoDomain{" +
                "customUserData='" + customUserData + '\'' +
                '}';
    }
}