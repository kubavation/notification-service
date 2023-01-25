package com.durys.jakub.notificationservice.infrastructure.`in`

import com.durys.jakub.notificationservice.notification.NotificationService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/notifications")
internal class NotificationController(val notificationService: NotificationService) {
}