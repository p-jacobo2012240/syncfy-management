package com.syncfy.management.application.repositories;

import com.syncfy.management.domain.AlertDtoDomain;

import java.util.List;

public interface IAlertRepository extends IBaseRepository<AlertDtoDomain, Long> {
    List<AlertDtoDomain> findAlertsByAuth(Long authId);
}
