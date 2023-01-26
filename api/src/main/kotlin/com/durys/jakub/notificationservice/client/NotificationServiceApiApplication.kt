package com.durys.jakub.notificationservice.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotificationServiceApiApplication

fun main(args: Array<String>) {
	runApplication<NotificationServiceApiApplication>(*args)
}
