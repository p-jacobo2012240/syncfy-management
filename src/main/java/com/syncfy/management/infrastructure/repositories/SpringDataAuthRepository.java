package com.syncfy.management.infrastructure.repositories;

import com.syncfy.management.infrastructure.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAuthRepository extends JpaRepository<Auth, Long > {
}
