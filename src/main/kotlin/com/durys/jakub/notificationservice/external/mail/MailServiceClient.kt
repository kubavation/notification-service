package com.durys.jakub.notificationservice.external.mail

import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient

internal class MailServiceClient(private val webClient: WebClient) {

    fun send(mail: Mail) {
        webClient
            .post()
            .uri("/mails")
            .body(BodyInserters.fromValue(mail))
            .exchange().block()
    }

}