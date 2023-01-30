package com.durys.jakub.notificationservice.notification.urlbuilder


fun String.href(ref: String) = "$this href=\"${ref}\">"

fun String.label(label: String) ="$this>${label}"

fun String.build() = "$this</a>"

object UrlBuilder {

    private const val Link = "<a";

    fun build(url: String): String {
        return Link.href(url).label("Link to application").build()
    }
}