package com.syncfy.management.infrastructure.services;

import com.syncfy.management.domain.*;

import java.util.List;

public interface IMetricService {
    AlertDtoDomain newAlert(AlertDtoCreatorDomain creatorDomain);
    List<AlertDtoDomain> alertsByOAuth(String id);
    void deleteAlertByOAuth(String id);
    NotificationDtoDomain newNotification(NotificationDtoCreatorDomain creatorDomain);
    List<NotificationDtoDomain> notificationByOAuth(String id);
    void deleteNotificationById(String id);
}
