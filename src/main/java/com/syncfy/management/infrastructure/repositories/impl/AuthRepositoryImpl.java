package com.syncfy.management.infrastructure.repositories.impl;

import com.syncfy.management.application.repositories.IAuthRepository;
import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.domain.AuthDtoPayloadDomain;
import com.syncfy.management.infrastructure.filters.AuthSpecification;
import com.syncfy.management.infrastructure.mappers.AuthDtoMapper;
import com.syncfy.management.infrastructure.repositories.SpringDataAuthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthRepositoryImpl implements IAuthRepository {

    private Logger log = LoggerFactory.getLogger(AuthRepositoryImpl.class);

    @Autowired
    private SpringDataAuthRepository authRepository;

    @Autowired
    private AuthSpecification specification;

    @Autowired
    private AuthDtoMapper mapper;

    @Override
    public <S extends AuthDtoDomain> S save(S s) {
        return (S) mapper.toDomain(authRepository.save(mapper.toEntity(s)));
    }

    @Override
    public Optional<AuthDtoDomain> findById(Long id) {
        return Optional.of(mapper.toDomain(authRepository.findById(id).get()));
    }

    @Override
    public Iterable<AuthDtoDomain> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
    @Override
    public AuthDtoDomain findByContext(AuthDtoPayloadDomain payloadDomain) {

        this.log.info("auth_id = {} ", payloadDomain.getAuthId() );
        return null;
    }
}
