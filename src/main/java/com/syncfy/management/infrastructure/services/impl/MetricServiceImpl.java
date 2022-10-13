package com.syncfy.management.infrastructure.services.impl;

import com.syncfy.management.domain.AlertDtoCreatorDomain;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.infrastructure.mappers.AlertDtoMapper;
import com.syncfy.management.infrastructure.repositories.impl.AlertRepositoryImpl;
import com.syncfy.management.infrastructure.services.IMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricServiceImpl implements IMetricService {

    @Autowired
    private AlertRepositoryImpl alertRepository;

    @Autowired
    private AlertDtoMapper alertDtoMapper;

    @Override
    public AlertDtoDomain newAlert(AlertDtoCreatorDomain creatorDomain) {
        return alertRepository.save(alertDtoMapper.fromCreatorToDomain(creatorDomain));
    }

    @Override
    public List<AlertDtoDomain> alertsByOAuth(String id) {
        return alertRepository.findAlertsByAuth(Long.parseLong(id));
    }

    @Override
    public void deleteAlertByOAuth(String id) {
        alertRepository.deleteById(Long.parseLong(id));
    }
}
