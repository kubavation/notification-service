package com.durys.jakub.notificationservice.infrastructure.out

import com.durys.jakub.notificationservice.notification.NotificationType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
class Notification(@Id val id: String,
                   val tenantId: String,
                   val subject: String,
                   val content: String,
                   val types: List<NotificationType>) {

    var status: NotificationStatus = NotificationStatus.ACTIVE
    val creationDate: LocalDateTime = LocalDateTime.now()

    fun withStatus(status: NotificationStatus): Notification {
        this.status = status
        return this
    }

}