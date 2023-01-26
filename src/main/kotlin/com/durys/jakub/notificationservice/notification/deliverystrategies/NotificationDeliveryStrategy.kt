package com.durys.jakub.notificationservice.notification.deliverystrategies

import com.durys.jakub.notificationservice.infrastructure.out.Notification

internal interface NotificationDeliveryStrategy {
    fun deliver(notification: Notification)
}