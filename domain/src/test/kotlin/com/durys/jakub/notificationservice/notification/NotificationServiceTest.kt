package com.durys.jakub.notificationservice.notification

import com.durys.jakub.notificationservice.infrastructure.NotificationRepository
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

    }
}