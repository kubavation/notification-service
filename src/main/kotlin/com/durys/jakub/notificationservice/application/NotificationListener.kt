package com.durys.jakub.notificationservice.application

import com.durys.jakub.notificationservice.notification.Notification
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
internal class NotificationListener(private val messagingTemplate: SimpMessagingTemplate) {

    @RabbitListener(queues = ["q.notification-queue"])
    fun listen(notification: Notification) {
        messagingTemplate.convertAndSend("/topic/notifications", notification)
    }
}