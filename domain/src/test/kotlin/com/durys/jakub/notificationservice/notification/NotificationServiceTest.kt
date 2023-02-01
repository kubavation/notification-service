package com.durys.jakub.notificationservice.notification

import com.durys.jakub.notificationservice.infrastructure.NotificationRepository
import com.durys.jakub.notificationservice.infrastructure.out.Notification
import com.durys.jakub.notificationservice.infrastructure.out.NotificationStatus
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito

internal class NotificationServiceTest {

    val notificationRepository = Mockito.mock(NotificationRepository::class.java)
    val notificationDeliveryStrategyFactory = Mockito.mock(NotificationDeliveryStrategyFactory::class.java)

    val notificationService = NotificationService(notificationDeliveryStrategyFactory, notificationRepository)

    @Test
    fun markNotificationsAsInactive_shouldChangeStatusToInactive() {
        val notifications = listOf(
                NotificationDTO(TenantId("1"), "test1", "test1", listOf(NotificationType.APP))
                        .withId("1"),
                NotificationDTO(TenantId("2"), "test2", "test2", listOf(NotificationType.APP))
                        .withId("2")
        )

        val entities = listOf(
                Notification("1", "1", "test1", "test1", null, listOf(NotificationType.APP)),
                Notification("2", "1", "test2", "test2", null, listOf(NotificationType.APP)))

        Mockito.`when`(notificationRepository.findAllById(listOf("1", "2"))).thenReturn(entities)

        notificationService.markAsInactive(notifications)

        entities.forEach {
            assertEquals(NotificationStatus.INACTIVE, it.status)
        }
    }
}