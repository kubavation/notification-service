package com.durys.jakub.notificationservice.external.accessmanagement

import com.durys.jakub.notificationservice.notification.TenantId

import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

internal class TenantEmailNotFoundException(tenantId: TenantId?): RuntimeException("Tenant email of id ${tenantId?.value} not found")

internal class AccessManagementServiceClient(private val webClient: WebClient) {

    fun receiverEmail(tenantId: TenantId?): Mono<String> {
        return webClient
                .get()
                .uri("/users/${tenantId?.value}/info")
                .retrieve()
                .bodyToMono(Receiver::class.java)
                .onErrorMap { TenantEmailNotFoundException(tenantId) }
                .map { it.email }
    }

}