package com.durys.jakub.notificationservice.infrastructure.out

import org.springframework.data.mongodb.repository.MongoRepository

interface NotificationRepository: MongoRepository<Notification, String> {
}