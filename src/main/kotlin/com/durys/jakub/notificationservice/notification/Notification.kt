package com.durys.jakub.notificationservice.notification

class Notification(val tenantId: TenantId, val subject: String, val content: String) {
    var withEmail = false
    var url = "";

    fun withEmail(value: Boolean): Notification {
        this.withEmail = value
        return this
    }

    fun withUrl(value: String): Notification {
        this.url = value
        return this
    }
}