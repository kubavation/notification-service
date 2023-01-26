package com.durys.jakub.notificationservice.notification.deliverystrategies

import com.durys.jakub.notificationservice.infrastructure.out.Notification
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
internal class WebSocketNotificationDeliveryStrategy(private val messagingTemplate: SimpMessagingTemplate): NotificationDeliveryStrategy {

    override fun deliver(notification: Notification) {
        messagingTemplate
                .convertAndSendToUser(notification.tenantId, "/queue/notifications", notification)
    }
}