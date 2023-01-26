package com.durys.jakub.notificationservice.notification.deliverystrategies

import com.durys.jakub.notificationservice.external.accessmanagement.AccessManagementServiceClient
import com.durys.jakub.notificationservice.external.mail.Mail
import com.durys.jakub.notificationservice.external.mail.MailServiceClient
import com.durys.jakub.notificationservice.infrastructure.out.Notification
import com.durys.jakub.notificationservice.notification.TenantId
import org.springframework.stereotype.Service

@Service
internal class MailNotificationDeliveryStrategy(private val mailServiceClient: MailServiceClient,
                                                private val accessManagementServiceClient: AccessManagementServiceClient): NotificationDeliveryStrategy {

    override fun deliver(notification: Notification) {
        accessManagementServiceClient.receiverEmail(TenantId(notification.tenantId))
                .map { Mail(notification.subject, notification.content, it) }
                .flatMap { mailServiceClient.send(it) }
                .onErrorComplete()
                .block()
    }
}