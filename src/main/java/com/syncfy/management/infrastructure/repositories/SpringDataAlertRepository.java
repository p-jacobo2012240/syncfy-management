package com.syncfy.management.infrastructure.repositories;

import com.syncfy.management.infrastructure.entities.Alert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAlertRepository extends JpaRepository<Alert, Long  > {
    Page<Alert> findAll(Specification<Alert> spec, Pageable pageInfo);
}
