package com.durys.jakub.notificationservice.external.mail

import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

internal class MailServiceClient(private val webClient: WebClient) {

    fun send(mail: Mail): Mono<ClientResponse> {
       return webClient
            .post()
            .uri("/mails")
            .body(BodyInserters.fromValue(mail))
            .exchange()
    }

}