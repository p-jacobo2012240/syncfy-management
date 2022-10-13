package com.syncfy.management.infrastructure.services.impl;

import com.syncfy.management.domain.AlertDtoCreatorDomain;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.infrastructure.services.IMetricService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricServiceImpl implements IMetricService {

    @Override
    public AlertDtoDomain newAlert(AlertDtoCreatorDomain creatorDomain) {
        return null;
    }

    @Override
    public List<AlertDtoDomain> alertsByOAuth(String id) {
        return null;
    }

    @Override
    public void deleteAlertByOAuth(String id) {

    }
}
