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

    Alert toEntity(AlertDtoDomain domain);

    AlertDtoDomain toDomain(Alert alert);

    AlertDtoDomain fromCreatorToDomain(AlertDtoCreatorDomain creatorDomain);
}
