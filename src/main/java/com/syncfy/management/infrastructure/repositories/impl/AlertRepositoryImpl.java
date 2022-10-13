package com.syncfy.management.infrastructure.repositories.impl;

import com.syncfy.management.application.repositories.IMetricRepository;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.infrastructure.entities.Alert;
import com.syncfy.management.infrastructure.repositories.SpringDataAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlertRepositoryImpl implements IMetricRepository {

    @Autowired
    private SpringDataAlertRepository alertRepository;

    @Override
    public <S extends AlertDtoDomain> S save(S s) {
        return null;
    }

    @Override
    public Optional<AlertDtoDomain> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<AlertDtoDomain> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
