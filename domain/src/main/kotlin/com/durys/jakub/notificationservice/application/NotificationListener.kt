package com.durys.jakub.notificationservice.application

import com.durys.jakub.notificationservice.commons.NotificationAssembler
import com.durys.jakub.notificationservice.infrastructure.NotificationRepository
import com.durys.jakub.notificationservice.notification.NotificationDTO
import com.durys.jakub.notificationservice.notification.NotificationService
import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

private val logger = KotlinLogging.logger {}

@Service
internal class NotificationListener(
        private val notificationService: NotificationService,
        private val notificationRepository: NotificationRepository) {

    @RabbitListener(queues = ["\${queue.notification}"])
    fun listen(notificationDTO: NotificationDTO) {

        logger.info {
            "got notification for tenantId: ${notificationDTO.tenantId?.value} with types: ${notificationDTO.types})"
        }

        notificationDTO.tenantId?.value?.let {
            val entity = notificationRepository.save(NotificationAssembler.toEntity(notificationDTO))
            notificationService.process(entity);
        }

    }
}