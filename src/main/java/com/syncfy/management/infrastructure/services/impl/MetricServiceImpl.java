package com.syncfy.management.infrastructure.services.impl;

import com.syncfy.management.domain.AlertDtoCreatorDomain;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.domain.NotificationDtoCreatorDomain;
import com.syncfy.management.domain.NotificationDtoDomain;
import com.syncfy.management.infrastructure.mappers.AlertDtoMapper;
import com.syncfy.management.infrastructure.mappers.NotificationDtoMapper;
import com.syncfy.management.infrastructure.repositories.impl.AlertRepositoryImpl;
import com.syncfy.management.infrastructure.repositories.impl.NotificationRepositoryImpl;
import com.syncfy.management.infrastructure.services.IMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricServiceImpl implements IMetricService {
    @Autowired
    private AlertRepositoryImpl alertRepository;
    @Autowired
    private NotificationRepositoryImpl notificationRepository;
    @Autowired
    private AlertDtoMapper alertDtoMapper;

    @Autowired
    private NotificationDtoMapper notificationDtoMapper;

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

    @Override
    public NotificationDtoDomain newNotification(NotificationDtoCreatorDomain creatorDomain) {
        return notificationRepository.save(notificationDtoMapper.fromCreatorToDomain(creatorDomain));
    }

    @Override
    public List<NotificationDtoDomain> notificationByOAuth(String id) {
        return notificationRepository.findNotificationsByAuth(Long.parseLong(id));
    }

    @Override
    public void deleteNotificationById(String id) {
        notificationRepository.deleteById(Long.parseLong(id));
    }
}
