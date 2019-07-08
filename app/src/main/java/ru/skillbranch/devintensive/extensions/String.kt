package ru.skillbranch.devintensive.extensions

fun String.truncate(max: Int = 13):String = if (max >= trimEnd().length) "${this.trimEnd()}"
else "${this.substring(0, max).trimEnd()}..."

fun String.stripHtml(): String = this
    .replace(Regex("<[^>]*>"), "")
    .replace(Regex("&amp;|&lt;|&gt;|&quot;|&apos;|&#\\d+;"), "")
    .replace(Regex(" +"), " ")