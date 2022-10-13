package com.syncfy.management.infrastructure.repositories.impl;

import com.syncfy.management.application.repositories.IAuthRepository;
import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.infrastructure.repositories.SpringDataAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthRepositoryImpl implements IAuthRepository {

    @Autowired
    private SpringDataAuthRepository authRepository;

    @Override
    public <S extends AuthDtoDomain> S save(S s) {
        return null;
    }

    @Override
    public Optional<AuthDtoDomain> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<AuthDtoDomain> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
