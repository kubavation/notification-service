package com.durys.jakub.notificationservice.application

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class NotificationController {

    @MessageMapping("/notify")
    @SendTo("/topic")
    fun send(@Payload message: String): String {
        println(message)
        return message
    }
}