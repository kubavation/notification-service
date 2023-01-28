package com.durys.jakub.notificationservice.client.model

import com.durys.jakub.notificationservice.notification.NotificationType
import com.durys.jakub.notificationservice.notification.TenantId

class NotificationDTO(val tenantId: TenantId? = null,
                      val subject: String? = null,
                      val content: String? = null,
                      val types: List<NotificationType> = listOf(NotificationType.APP)) {

    var id: String = "";
    var url = ""

    fun withUrl(value: String): NotificationDTO {
        this.url = value
        return this
    }

    infix fun ofType(type: NotificationType) = types.contains(type)
}