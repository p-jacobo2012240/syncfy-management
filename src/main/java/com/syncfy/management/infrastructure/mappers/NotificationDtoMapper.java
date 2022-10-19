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

    @Mapping(source = "id", target = "notificationId")
    Notification toEntity(NotificationDtoDomain domain);

    @Mapping(source = "notificationId", target = "id")
    NotificationDtoDomain toDomain(Notification entity);

    @Mapping(source = "auth0_id", target = "auth.id")
    NotificationDtoDomain fromCreatorToDomain(NotificationDtoCreatorDomain creatorDomain);
}
