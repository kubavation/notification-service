package com.durys.jakub.notificationservice.external

import com.durys.jakub.notificationservice.external.accessmanagement.AccessManagementServiceClient
import com.durys.jakub.notificationservice.external.mail.MailServiceClient
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
internal class ExternalClientConfiguration {

    @Bean
    @LoadBalanced
    fun mailWebClient(@Value("\${mail.service.url}") mailServiceUrl: String): WebClient.Builder =
            WebClient.builder().baseUrl(mailServiceUrl)

    @Bean
    fun mailServiceClient(@Qualifier("mailWebClient") webClient: WebClient.Builder): MailServiceClient = MailServiceClient(webClient.build())

    @Bean
    @LoadBalanced
    fun accessManagementWebClient(@Value("\${access-management.service.url}") amServiceUrl: String): WebClient.Builder =
            WebClient.builder().baseUrl(amServiceUrl)

    @Bean
    fun accessManagementServiceClient(@Qualifier("accessManagementWebClient") webClient: WebClient.Builder): AccessManagementServiceClient
            = AccessManagementServiceClient(webClient.build())

}