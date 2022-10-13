package com.syncfy.management.infrastructure.repositories.impl;

import com.syncfy.management.application.repositories.IMetricRepository;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.infrastructure.entities.Alert;
import com.syncfy.management.infrastructure.entities.Auth;
import com.syncfy.management.infrastructure.filters.AlertSpecification;
import com.syncfy.management.infrastructure.mappers.AlertDtoMapper;
import com.syncfy.management.infrastructure.repositories.SpringDataAlertRepository;
import com.syncfy.management.infrastructure.repositories.SpringDataAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AlertRepositoryImpl implements IMetricRepository {

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
        Auth auth = authRepository.findById(alert.getAuth().getAuthId()).get();

        //setting child entity
        alert.setAuth(auth);
        return (S) mapper.toDomain(alertRepository.save(alert));
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
        Sort sort = Sort.by(Sort.Order.desc("alertId"));
        Pageable pageInfo = PageRequest.of(10, 10, sort);
        Specification<Alert> spec = specification.toSpec(authId);
        Page<Alert> alertList =  alertRepository.findAll(spec, pageInfo);

        return alertList.getContent()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
