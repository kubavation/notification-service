package com.durys.jakub.notificationservice.notification.deliverystrategies

import com.durys.jakub.notificationservice.infrastructure.out.Notification
import org.springframework.stereotype.Service

@Service
internal class SmsNotificationDeliveryStrategy(): NotificationDeliveryStrategy {

    override fun deliver(notification: Notification) {
        TODO()
    }
}