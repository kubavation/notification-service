package com.durys.jakub.notificationservice.ws

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableAsync
@EnableWebSocketMessageBroker
internal class WebSocketConfiguration: WebSocketMessageBrokerConfigurer {

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry
            .setApplicationDestinationPrefixes("/app")
            .setUserDestinationPrefix("/tenant")
            .enableSimpleBroker("/tenant")
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry
                .addEndpoint("/notifications")
                .setAllowedOriginPatterns("*")
                .withSockJS()
                .setHeartbeatTime(1000)
    }
}