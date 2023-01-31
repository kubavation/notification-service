package com.durys.jakub.notificationservice.commons

import com.durys.jakub.notificationservice.infrastructure.out.Notification
import com.durys.jakub.notificationservice.notification.NotificationDTO
import com.durys.jakub.notificationservice.notification.TenantId
import java.util.UUID

internal object NotificationAssembler {

    fun toEntity(dto: NotificationDTO): Notification {
        return Notification(UUID.randomUUID().toString(), dto.tenantId?.value!!, dto.subject!!, dto.content!!, dto.url, dto.types)
    }

    fun toDTO(entity: Notification): NotificationDTO {
       return NotificationDTO(TenantId(entity.tenantId), entity.subject, entity.content, entity.types)
               .withId(entity.id)
    }
}