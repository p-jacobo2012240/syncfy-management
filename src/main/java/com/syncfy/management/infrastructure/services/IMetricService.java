package com.syncfy.management.infrastructure.services;

import com.syncfy.management.domain.AlertDtoCreatorDomain;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.domain.AuthDtoPayloadDomain;

import java.util.List;

public interface IMetricService {
    AlertDtoDomain newAlert(AlertDtoCreatorDomain creatorDomain);
    List<AlertDtoDomain> alertsByOAuth(String id);
    void deleteAlertByOAuth(String id);
}
