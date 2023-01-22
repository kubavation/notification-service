package com.durys.jakub.notificationservice.external

import com.durys.jakub.notificationservice.external.mail.MailServiceClient
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
internal class ExternalClientConfiguration {

    @Bean
    @LoadBalanced
    fun mailWebClient(): WebClient.Builder = WebClient.builder().baseUrl("http://MAIL-SERVICE")

    @Bean
    fun mailServiceClient(@Qualifier("mailWebClient") webClient: WebClient.Builder): MailServiceClient = MailServiceClient(webClient.build())

    @Bean
    @LoadBalanced
    fun accessManagementWebClient(): WebClient.Builder = WebClient.builder().baseUrl("http://ACCESS-MANAGEMENT")
}