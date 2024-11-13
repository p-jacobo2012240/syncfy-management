package com.syncfy.management.infrastructure.repositories;

import com.syncfy.management.infrastructure.entities.Auth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataAuthRepository extends JpaRepository<Auth, Long > {
    Optional<Auth> findBySub(String sub);
}