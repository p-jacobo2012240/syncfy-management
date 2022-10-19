package com.syncfy.management.application.repositories;

import com.syncfy.management.domain.NotificationDtoDomain;

import java.util.List;

public interface INotificationRepository extends IBaseRepository<NotificationDtoDomain, Long> {

    List<NotificationDtoDomain> findNotificationsByAuth(Long authId);
}