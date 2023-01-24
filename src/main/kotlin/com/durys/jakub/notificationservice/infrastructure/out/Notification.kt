package com.durys.jakub.notificationservice.infrastructure.out

import com.durys.jakub.notificationservice.notification.NotificationType
import com.durys.jakub.notificationservice.notification.TenantId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Notification(@Id val id: String,
                   val tenantId: TenantId,
                   val subject: String,
                   val content: String,
                   val type: List<NotificationType>) {
}