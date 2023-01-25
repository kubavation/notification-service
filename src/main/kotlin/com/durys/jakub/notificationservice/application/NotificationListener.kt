package com.durys.jakub.notificationservice.application

import com.durys.jakub.notificationservice.commons.NotificationAssembler
import com.durys.jakub.notificationservice.infrastructure.NotificationRepository
import com.durys.jakub.notificationservice.notification.NotificationDTO
import com.durys.jakub.notificationservice.notification.NotificationService
import com.durys.jakub.notificationservice.notification.NotificationType
import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
internal class NotificationListener(
        private val messagingTemplate: SimpMessagingTemplate,
        private val notificationService: NotificationService,
        private val notificationRepository: NotificationRepository) {

    @RabbitListener(queues = ["q.notification-queue"])
    fun listen(notificationDTO: NotificationDTO) {

        logger.info {
            "got notification for tenantId: ${notificationDTO.tenantId?.value} with types: ${notificationDTO.types})"
        }

        notificationDTO.tenantId?.value?.let {

            notificationRepository.save(NotificationAssembler.toEntity(notificationDTO))

            messagingTemplate
                    .convertAndSendToUser(notificationDTO.tenantId.value, "/queue/notifications", notificationDTO)

            if (notificationDTO ofType NotificationType.EMAIL) {
                notificationService.process(notificationDTO)
            }
        }

    }
}