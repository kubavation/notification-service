package com.durys.jakub.notificationservice.notification

import com.durys.jakub.notificationservice.commons.NotificationAssembler
import com.durys.jakub.notificationservice.external.accessmanagement.AccessManagementServiceClient
import com.durys.jakub.notificationservice.external.mail.Mail
import com.durys.jakub.notificationservice.external.mail.MailServiceClient
import com.durys.jakub.notificationservice.infrastructure.NotificationRepository
import com.durys.jakub.notificationservice.infrastructure.out.Notification
import com.durys.jakub.notificationservice.infrastructure.out.NotificationStatus
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
internal class NotificationService(val notificationDeliveryStrategyFactory: NotificationDeliveryStrategyFactory,
                                   val notificationRepository: NotificationRepository,) {



    fun process(notification: Notification) {
        notification.types.forEach {
            notificationDeliveryStrategyFactory.from(it).deliver(notification)
        }
    }

    fun findAllByTenantIdAndStatus(tenantId: String, status: NotificationStatus): List<NotificationDTO> {
        return notificationRepository.findAllByTenantAndStatus(tenantId, status, Sort.by(Sort.Direction.DESC,"creationDate"))
                .map { NotificationAssembler.toDTO(it) }
    }

    fun findAllByTenantId(tenantId: String): List<NotificationDTO> {
        return notificationRepository.findAllByTenant(tenantId, Sort.by(Sort.Direction.DESC,"creationDate"))
                .map { NotificationAssembler.toDTO(it) }
    }

    @Transactional
    fun markAsInactive(notifications: List<NotificationDTO>) {
       val entities = notificationRepository.findAllById(notifications.map { it.id }.toList())
               .map { e -> e.withStatus(NotificationStatus.INACTIVE) }
        notificationRepository.saveAll(entities)
    }

    @Transactional
    fun markAsDeleted(notifications: List<NotificationDTO>) {
        val entities = notificationRepository.findAllById(notifications.map { it.id }.toList())
                .map { e -> e.withStatus(NotificationStatus.DELETED) }
        notificationRepository.saveAll(entities)
    }
}