package com.syncfy.management.infrastructure.mappers;

import com.syncfy.management.domain.AlertDtoCreatorDomain;
import com.syncfy.management.domain.AlertDtoDomain;
import com.syncfy.management.infrastructure.entities.Alert;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses =  { AuthDtoMapper.class }
)
public interface AlertDtoMapper {

    @Mapping(source = "id", target = "alertId")
    Alert toEntity(AlertDtoDomain domain);

    @Mapping(source = "alertId", target = "id")
    AlertDtoDomain toDomain(Alert alert);

    @Mapping(source = "auth0_id", target = "auth.id")
    AlertDtoDomain fromCreatorToDomain(AlertDtoCreatorDomain creatorDomain);
}
