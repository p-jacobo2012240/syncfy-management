package com.syncfy.management.domain;

import lombok.Data;

import java.time.OffsetTime;

@Data
public class AuthDtoDomain {
    private String oAuthId;
    private OffsetTime createdAt;
    private OffsetTime updatedAt;
    private Boolean isActive;
    private String customUserData;

    @Override
    public String toString() {
        return "AuthDtoDomain{" +
                "customUserData='" + customUserData + '\'' +
                '}';
    }
}