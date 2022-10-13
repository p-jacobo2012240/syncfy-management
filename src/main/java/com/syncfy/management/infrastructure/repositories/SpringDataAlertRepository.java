package com.syncfy.management.infrastructure.repositories;

import com.syncfy.management.infrastructure.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAlertRepository extends JpaRepository<Alert, Long> {
}
