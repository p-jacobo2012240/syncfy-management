package com.syncfy.management.infrastructure.repositories;

import com.syncfy.management.infrastructure.entities.Auth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAuthRepository extends JpaRepository<Auth, Long > {
    Page<Auth> findAll(Specification<Auth> spec, Pageable pageInfo);
}