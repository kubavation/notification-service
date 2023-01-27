package com.durys.jakub.notificationservice.client.api

import com.durys.jakub.notificationservice.notification.NotificationDTO
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class NotificationApiClient(private val rabbitTemplate: RabbitTemplate,
                            @Value("\${queue.notification}") private val queue: String) {


    fun publish(notification: NotificationDTO)
            = rabbitTemplate.convertAndSend(queue, notification)
}