package com.durys.jakub.notificationservice.infrastructure

import com.durys.jakub.notificationservice.infrastructure.out.Notification
import org.springframework.data.mongodb.repository.MongoRepository

interface NotificationRepository: MongoRepository<Notification, String> {
}