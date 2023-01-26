package com.durys.jakub.notificationservice.notification.deliverystrategies

import com.durys.jakub.notificationservice.infrastructure.out.Notification
import org.springframework.messaging.simp.SimpMessagingTemplate

class WebSocketNotificationDeliveryStrategy(private val messagingTemplate: SimpMessagingTemplate): NotificationDeliveryStrategy {

    override fun deliver(notification: Notification) {
        messagingTemplate
                .convertAndSendToUser(notification.tenantId, "/queue/notifications", notification)
    }
}