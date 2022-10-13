package com.syncfy.management.infrastructure.services.impl;

import com.syncfy.management.domain.AuthDtoCreatorDomain;
import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.domain.AuthDtoPayloadDomain;
import com.syncfy.management.infrastructure.mappers.AuthDtoMapper;
import com.syncfy.management.infrastructure.repositories.impl.AuthRepositoryImpl;
import com.syncfy.management.infrastructure.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private AuthRepositoryImpl authRepository;

    @Autowired
    private AuthDtoMapper mapper;

    @Override
    public AuthDtoDomain validateOAuth(AuthDtoPayloadDomain payloadDomain) {
        return authRepository.findByContext(payloadDomain);
    }

    @Override
    public AuthDtoDomain newOAuthRegister(AuthDtoCreatorDomain domain) {
        return authRepository.save(mapper.fromCreatorToDomain(domain));
    }
}