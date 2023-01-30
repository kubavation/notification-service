package com.durys.jakub.notificationservice.external.mail

import com.durys.jakub.notificationservice.notification.urlbuilder.UrlBuilder

internal class Mail(val subject: String?, val content: String?, url: String?) {

    val destination: String?

    init {
        this.destination = url?.let { UrlBuilder.build(it) }
    }
}