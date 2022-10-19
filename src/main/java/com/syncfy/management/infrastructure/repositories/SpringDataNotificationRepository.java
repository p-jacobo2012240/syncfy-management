package com.syncfy.management.infrastructure.repositories;

import com.syncfy.management.infrastructure.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataNotificationRepository extends JpaRepository<Notification, Long> {
}
