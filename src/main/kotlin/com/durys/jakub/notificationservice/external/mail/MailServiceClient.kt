package com.durys.jakub.notificationservice.external.mail

import org.springframework.web.reactive.function.client.WebClient

internal class MailServiceClient(private val webClient: WebClient.Builder) {
}