package com.syncfy.management.infrastructure.repositories.impl;

import com.syncfy.management.application.repositories.IAlertRepository;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.infrastructure.entities.Alert;
import com.syncfy.management.infrastructure.entities.Auth;
import com.syncfy.management.infrastructure.filters.AlertSpecification;
import com.syncfy.management.infrastructure.mappers.AlertDtoMapper;
import com.syncfy.management.infrastructure.repositories.SpringDataAlertRepository;
import com.syncfy.management.infrastructure.repositories.SpringDataAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AlertRepositoryImpl implements IAlertRepository {

    @Autowired
    private SpringDataAlertRepository alertRepository;

    @Autowired
    private SpringDataAuthRepository authRepository;
    @Autowired
    private AlertSpecification specification;

    @Autowired
    private AlertDtoMapper mapper;

    @Override
    public <S extends AlertDtoDomain> S save(S s) {
        Alert alert = mapper.toEntity(s);
        Auth auth = authRepository.findById(null).get();

        //setting child entity
        // alert.setAuth(auth);
        // return (S) mapper.toDomain(alertRepository.save(alert));
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
        alertRepository.deleteById(id);
    }

    @Override
    public List<AlertDtoDomain> findAlertsByAuth(Long authId) {
        //TEMP
        List<Alert> alerts = alertRepository.findAll();
        /** alerts = alerts.stream()
                .filter(alert -> alert.getAuth().getAuthId() == authId)
                .collect(Collectors.toList()); */

        return  alerts.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
