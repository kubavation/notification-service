package com.durys.jakub.notificationservice.infrastructure

import com.durys.jakub.notificationservice.infrastructure.out.Notification
import com.durys.jakub.notificationservice.infrastructure.out.NotificationStatus
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface NotificationRepository: MongoRepository<Notification, String> {

    @Query("{'tenantId' : ?0}")
    fun findAllByTenant(tenantId: String, sort: Sort)

    @Query("{'tenantId' : ?0, 'status' : ?1}")
    fun findAllByTenantAndStatus(tenantId: String, status: NotificationStatus, sort: Sort)
}