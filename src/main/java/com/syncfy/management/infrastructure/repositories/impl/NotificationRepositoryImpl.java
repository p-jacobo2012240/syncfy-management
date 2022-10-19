package com.syncfy.management.infrastructure.repositories.impl;

import com.syncfy.management.application.repositories.INotificationRepository;
import com.syncfy.management.domain.NotificationDtoDomain;
import com.syncfy.management.infrastructure.entities.Auth;
import com.syncfy.management.infrastructure.entities.Notification;
import com.syncfy.management.infrastructure.mappers.NotificationDtoMapper;
import com.syncfy.management.infrastructure.repositories.SpringDataAuthRepository;
import com.syncfy.management.infrastructure.repositories.SpringDataNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class NotificationRepositoryImpl implements INotificationRepository {

    @Autowired
    private SpringDataNotificationRepository notificationRepository;

    @Autowired
    private SpringDataAuthRepository authRepository;

    @Autowired
    private NotificationDtoMapper mapper;

    @Override
    public <S extends NotificationDtoDomain> S save(S s) {
        Notification notification = mapper.toEntity(s);
        Auth auth = authRepository.findById(notification.getAuth().getAuthId()).get();

        notification.setAuth(auth);
        return (S) mapper.toDomain(notificationRepository.save(notification));
    }

    @Override
    public Optional<NotificationDtoDomain> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<NotificationDtoDomain> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }

    @Override
    public List<NotificationDtoDomain> findNotificationsByAuth(Long authId) {
        List<Notification> alerts = notificationRepository.findAll();
        alerts = alerts.stream()
                .filter(alert -> alert.getAuth().getAuthId() == authId)
                .collect(Collectors.toList());

        return  alerts.stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
