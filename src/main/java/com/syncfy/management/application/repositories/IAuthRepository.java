package com.syncfy.management.application.repositories;

import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.domain.AuthDtoPayloadDomain;

public interface IAuthRepository extends IBaseRepository<AuthDtoDomain, Long> {
    AuthDtoDomain findByContext(AuthDtoPayloadDomain payloadDomain);
}
