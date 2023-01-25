package com.durys.jakub.notificationservice.infrastructure.`in`

import com.durys.jakub.notificationservice.infrastructure.out.NotificationStatus
import com.durys.jakub.notificationservice.notification.NotificationDTO
import com.durys.jakub.notificationservice.notification.NotificationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/tenants/{tenantId}/notifications")
internal class NotificationController(val notificationService: NotificationService) {

    @GetMapping
    fun findAllByStatus(@PathVariable tenantId: String,
                        @RequestParam status: Optional<NotificationStatus>): List<NotificationDTO> {
        return status
                .map { notificationService.findAllByTenantIdAndStatus(tenantId, it) }
                .orElseGet {  notificationService.findAllByTenantId(tenantId) }
    }

}