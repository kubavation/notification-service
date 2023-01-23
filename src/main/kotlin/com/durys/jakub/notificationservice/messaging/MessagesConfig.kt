package com.durys.jakub.notificationservice.messaging

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class MessagesConfig {

    @Bean
    fun notificationQueue() = Queue("q.notification-queue")
}