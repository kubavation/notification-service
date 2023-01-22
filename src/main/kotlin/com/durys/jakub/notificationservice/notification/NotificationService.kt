package com.durys.jakub.notificationservice.notification

import com.durys.jakub.notificationservice.external.accessmanagement.AccessManagementServiceClient
import com.durys.jakub.notificationservice.external.mail.MailServiceClient
import org.springframework.stereotype.Service

@Service
internal class NotificationService(val mailServiceClient: MailServiceClient,
                                   val accessManagementServiceClient: AccessManagementServiceClient) {
}