package com.durys.jakub.notificationservice.notification

class Notification(val tenantId: TenantId? = null, val subject: String? = null, val content: String? = null) {
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