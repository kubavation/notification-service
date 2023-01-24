package com.durys.jakub.notificationservice.application

import com.durys.jakub.notificationservice.notification.NotificationDTO
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
    fun listen(notificationDTO: NotificationDTO) {

        logger.info {
            "got notification for tenantId: ${notificationDTO.tenantId?.value} (with email: ${notificationDTO.withEmail})"
        }

        notificationDTO.tenantId?.value?.let {

            messagingTemplate
                    .convertAndSendToUser(notificationDTO.tenantId.value, "/topic/notifications", notificationDTO)

            if (notificationDTO.withEmail) {
                notificationService.process(notificationDTO)
            }
        }

    }
}