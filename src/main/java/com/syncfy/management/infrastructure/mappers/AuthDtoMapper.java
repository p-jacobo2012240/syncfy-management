package com.syncfy.management.infrastructure.mappers;

import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.infrastructure.entities.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthDtoMapper {

    @Mapping(source = "OAuthId", target = "sub")
    Auth toEntity(AuthDtoDomain domain);

    @Mapping(source = "sub", target = "OAuthId")
    AuthDtoDomain toDomain(Auth entity);
}
