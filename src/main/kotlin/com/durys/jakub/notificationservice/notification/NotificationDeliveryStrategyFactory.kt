package com.durys.jakub.notificationservice.notification

import com.durys.jakub.notificationservice.notification.deliverystrategies.MailNotificationDeliveryStrategy
import com.durys.jakub.notificationservice.notification.deliverystrategies.NotificationDeliveryStrategy
import com.durys.jakub.notificationservice.notification.deliverystrategies.SmsNotificationDeliveryStrategy
import com.durys.jakub.notificationservice.notification.deliverystrategies.WebSocketNotificationDeliveryStrategy
import org.springframework.stereotype.Service

@Service
internal class NotificationDeliveryStrategyFactory(
        private val webSocketNotificationDeliveryStrategy: WebSocketNotificationDeliveryStrategy,
        private val mailNotificationDeliveryStrategy: MailNotificationDeliveryStrategy,
        private val smsNotificationDeliveryStrategy: SmsNotificationDeliveryStrategy) {


    fun from(notificationType: NotificationType): NotificationDeliveryStrategy {
       return when (notificationType) {
            NotificationType.APP -> webSocketNotificationDeliveryStrategy
            NotificationType.EMAIL -> mailNotificationDeliveryStrategy
            NotificationType.SMS -> smsNotificationDeliveryStrategy
        }
    }
}