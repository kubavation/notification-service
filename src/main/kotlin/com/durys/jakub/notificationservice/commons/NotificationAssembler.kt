package com.durys.jakub.notificationservice.commons

import com.durys.jakub.notificationservice.infrastructure.out.Notification
import com.durys.jakub.notificationservice.notification.NotificationDTO
import java.util.UUID

object NotificationAssembler {

    fun toEntity(dto: NotificationDTO): Notification {
        return Notification(UUID.randomUUID().toString(), dto.tenantId?.value!!, dto.subject!!, dto.content!!, dto.types)
    }
}