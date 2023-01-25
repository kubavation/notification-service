package com.durys.jakub.notificationservice.notification

class NotificationDTO(val tenantId: TenantId? = null, val subject: String? = null, val content: String? = null) {
    var url = "";
    var type: List<NotificationType> = listOf(NotificationType.APP)

    fun withUrl(value: String): NotificationDTO {
        this.url = value
        return this
    }
}