package com.syncfy.management.infrastructure.mappers;

import com.syncfy.management.domain.AuthDtoCreatorDomain;
import com.syncfy.management.domain.AuthDtoDomain;
import com.syncfy.management.infrastructure.entities.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthDtoMapper {

    Auth toEntity(AuthDtoDomain domain);

    AuthDtoDomain toDomain(Auth entity);

    AuthDtoDomain fromCreatorToDomain(AuthDtoCreatorDomain creatorDomain);

}
