package ru.skillbranch.devintensive.extensions

fun String.truncate(max: Int = 16): String =
    if (max >= this.trimEnd().length) "${this.trimEnd()}"
    else "${this.substring(0, max).trimEnd()}..."

fun String.stripHtml(): String = this
    /*.replace(Regex("<[^>]*>"), "")
    .replace(Regex("&amp;|&lt;|&gt;|&quot;|&apos;|&#\\d+;"), "")
    .replace(Regex(" +"), " ")*/

    .replace("<[^>]*>".toRegex(), "")
    .replace("\\s+".toRegex(), " ")