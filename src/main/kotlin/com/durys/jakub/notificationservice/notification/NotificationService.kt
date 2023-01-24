package com.durys.jakub.notificationservice.notification

import com.durys.jakub.notificationservice.external.accessmanagement.AccessManagementServiceClient
import com.durys.jakub.notificationservice.external.mail.Mail
import com.durys.jakub.notificationservice.external.mail.MailServiceClient
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
internal class NotificationService(val mailServiceClient: MailServiceClient,
                                   val accessManagementServiceClient: AccessManagementServiceClient) {


    fun process(notification: Notification) {
        accessManagementServiceClient.receiverEmail(notification.tenantId)
                .map { Mail(notification.subject, notification.content, it) }
                .flatMap { mailServiceClient.send(it) }
                .onErrorComplete()
                .block()
    }
}