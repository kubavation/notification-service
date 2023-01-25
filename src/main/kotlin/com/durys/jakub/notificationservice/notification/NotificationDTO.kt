package com.durys.jakub.notificationservice.notification

import com.durys.jakub.notificationservice.infrastructure.out.NotificationStatus

class NotificationDTO(val tenantId: TenantId? = null,
                      val subject: String? = null,
                      val content: String? = null,
                      val types: List<NotificationType> = listOf(NotificationType.APP)) {
    var url = "";
    var status: NotificationStatus = NotificationStatus.ACTIVE

    fun withUrl(value: String): NotificationDTO {
        this.url = value
        return this
    }

    infix fun ofType(type: NotificationType) = types.contains(type)
}