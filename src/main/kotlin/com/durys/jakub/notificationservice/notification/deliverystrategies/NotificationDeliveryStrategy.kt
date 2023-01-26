package com.durys.jakub.notificationservice.notification.deliverystrategies

import com.durys.jakub.notificationservice.infrastructure.out.Notification

interface NotificationDeliveryStrategy {
    fun deliver(notification: Notification)
}