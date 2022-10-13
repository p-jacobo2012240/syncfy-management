package com.syncfy.management.infrastructure.services.impl;

import com.syncfy.management.domain.AuthDtoCreatorDomain;
import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.domain.AuthDtoPayloadDomain;
import com.syncfy.management.infrastructure.services.IAuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Override
    public AuthDtoDomain validateOAuth(AuthDtoPayloadDomain payloadDomain) {
        return null;
    }

    @Override
    public AuthDtoDomain newOAuthRegister(AuthDtoCreatorDomain domain) {
        return null;
    }
}