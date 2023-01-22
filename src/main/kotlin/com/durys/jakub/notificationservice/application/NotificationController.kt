package com.durys.jakub.notificationservice.application

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationController {

    @MessageMapping("/notify")
    @SendTo("/notifications/") //todo
    fun send() {

    }
}