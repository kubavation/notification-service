package com.durys.jakub.notificationservice.application

import com.durys.jakub.notificationservice.notification.Notification
import com.durys.jakub.notificationservice.notification.NotificationService
import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
internal class NotificationListener(
        private val messagingTemplate: SimpMessagingTemplate,
        private val notificationService: NotificationService) {

    @RabbitListener(queues = ["q.notification-queue"])
    fun listen(notification: Notification) {

        logger.info {
            "got notification for tenantId: ${notification.tenantId?.value} (with email: ${notification.withEmail}"
        }

        messagingTemplate.convertAndSend("/topic/notifications", notification)

        if (notification.withEmail) {
            notificationService.process(notification)
        }
    }
}