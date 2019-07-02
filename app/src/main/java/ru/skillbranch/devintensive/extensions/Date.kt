package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnit): Date {
    var time = this.time

    time += when (units) {
        TimeUnit.SECOND-> value * SECOND
        TimeUnit.MINUTE-> value * MINUTE
        TimeUnit.HOUR-> value * HOUR
        TimeUnit.DAY-> value * DAY
        else -> throw IllegalStateException("invalid unit")
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()):String {
    //сделать отображение времени в нормальном виде
    //TODO()
    return "исправь меня"
}

enum class TimeUnit {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}