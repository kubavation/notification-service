package com.durys.jakub.notificationservice.external.accessmanagement

import com.durys.jakub.notificationservice.notification.TenantId
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

internal class AccessManagementServiceClient(private val webClient: WebClient) {

    fun receiverEmail(tenantId: TenantId?): Mono<String> {
        return webClient
                .get()
                .uri("/users/%s/info".format(tenantId?.value))
                .retrieve()
                .bodyToMono(Receiver::class.java)
                .map { it.email }
    }

}