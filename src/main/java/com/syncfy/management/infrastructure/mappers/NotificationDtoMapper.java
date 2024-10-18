package com.syncfy.management.infrastructure.mappers;

import com.syncfy.management.domain.NotificationDtoCreatorDomain;
import com.syncfy.management.domain.NotificationDtoDomain;
import com.syncfy.management.infrastructure.entities.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses =  { AuthDtoMapper.class }
)
public interface NotificationDtoMapper {

    Notification toEntity(NotificationDtoDomain domain);

    NotificationDtoDomain toDomain(Notification entity);

    NotificationDtoDomain fromCreatorToDomain(NotificationDtoCreatorDomain creatorDomain);
}
