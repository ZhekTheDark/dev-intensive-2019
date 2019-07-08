package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.absoluteValue

const val SECOND = 1000L
const val MINUTE = SECOND * 60
const val HOUR = MINUTE * 60
const val DAY = HOUR * 24

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND-> value * SECOND
        TimeUnits.MINUTE-> value * MINUTE
        TimeUnits.HOUR-> value * HOUR
        TimeUnits.DAY-> value * DAY
    }
    this.time = time
    return this
}

/*fun Date.humanizeDiff(date: Date = Date()):String {
    val diff = ((date.time - time) / 1000)

    return if (diff <= 0){
        when (diff) {
            in (-1)..0 -> "только что"
            in (-45)..(-2) -> "через несколько секунд"
            in (-75)..(-46) -> "через минуту"
            in (-45 * 60)..(-76) -> "через ${displayMinutesCorrect(diff.absoluteValue / 60)}"
            in (-75 * 60)..(-46 * 60)  -> "через час"
            in (-22 * 60 * 60)..(-76 * 60) -> "через ${displayHoursCorrect(diff.absoluteValue / 60 / 60)}"
            in (-26 * 60 * 60)..(-23 * 60 * 60) -> "через день"
            in (-360 * 60 * 60 * 24)..(-27 * 60 * 60) -> "через ${displayDaysCorrect(diff.absoluteValue / 60 / 60 / 24)}"
            else -> "более чем через год"
        }
    } else {
        when (diff) {
            in 0..1 -> "только что"
            in 2..45 -> "несколько секунд назад"
            in 46..75 -> "минуту назад"
            in 76..45 * 60 -> "${displayMinutesCorrect(diff / 60)} назад"
            in 46 * 60..75 * 60 -> "час назад"
            in 76 * 60..22 * 60 * 60 -> "${displayHoursCorrect(diff / 60 / 60)} назад"
            in 23 * 60 * 60..26 * 60 * 60 -> "день назад"
            in 27 * 60 * 60..360 * 60 * 60 * 24 -> "${displayDaysCorrect(diff / 60 / 60 / 24)} назад"
            else -> "более года назад"
        }
    }
}*/

fun Date.humanizeDiff(date: Date = Date()):String {
    val diff = ((date.time - time) / 1000)

    return if (diff <= 0){
        when (diff) {
            in (-1)..0 -> "только что"
            in (-45)..(-2) -> "через несколько секунд"
            in (-75)..(-46) -> "через минуту"
            in (-45 * 60)..(-76) -> "через ${TimeUnits.MINUTE.plural((diff.absoluteValue / 60).toInt())}"
            in (-75 * 60)..(-46 * 60)  -> "через час"
            in (-22 * 60 * 60)..(-76 * 60) -> "через ${TimeUnits.HOUR.plural((diff.absoluteValue / 60 / 60).toInt())}"
            in (-26 * 60 * 60)..(-23 * 60 * 60) -> "через день"
            in (-360 * 60 * 60 * 24)..(-27 * 60 * 60) -> "через ${TimeUnits.DAY.plural((diff.absoluteValue / 60 / 60 / 24).toInt())}"
            else -> "более чем через год"
        }
    } else {
        when (diff) {
            in 0..1 -> "только что"
            in 2..45 -> "несколько секунд назад"
            in 46..75 -> "минуту назад"
            in 76..45 * 60 -> "${TimeUnits.MINUTE.plural((diff.absoluteValue / 60).toInt())} назад"
            in 46 * 60..75 * 60 -> "час назад"
            in 76 * 60..22 * 60 * 60 -> "${TimeUnits.HOUR.plural((diff.absoluteValue / 60 / 60).toInt())} назад"
            in 23 * 60 * 60..26 * 60 * 60 -> "день назад"
            in 27 * 60 * 60..360 * 60 * 60 * 24 -> "${TimeUnits.DAY.plural((diff.absoluteValue / 60 / 60 / 24).toInt())} назад"
            else -> "более года назад"
        }
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int): String {
        return when (this) {
            SECOND -> when {
                value % 10 == 1-> "$value секунду"
                value % 10 in 2..4-> "$value секунды"
                value % 100 in 5..20-> "$value секунд"
                else -> "$value секунд"
            }
            MINUTE -> when {
                value % 10 == 1-> "$value минуту"
                value % 10 in 2..4-> "$value минуты"
                value % 100 in 5..20-> "$value минут"
                else -> "$value минут"
            }
            HOUR -> when {
                value % 10 == 1-> "$value час"
                value % 10 in 2..4-> "$value часа"
                value % 100 in 5..20-> "$value часов"
                else -> "$value часов"
            }
            DAY -> when {
                value % 10 == 1-> "$value день"
                value % 10 in 2..4-> "$value дня"
                value % 100 in 5..20-> "$value дней"
                else -> "$value дней"
            }
        }
    }
}

/*enum class Plurals {
    ONE,
    FEW,
    MANY
}

val Long.asPlurals
    get() = when {
        this % 10L == 1L -> Plurals.ONE
        this % 10L in 2L..4L -> Plurals.FEW
        this % 100L in 5L..20L -> Plurals.MANY
        else -> Plurals.MANY
    }

fun displayMinutesCorrect(value: Long) = when (value.asPlurals){
    Plurals.ONE -> "$value минуту"
    Plurals.FEW -> "$value минуты"
    Plurals.MANY -> "$value минут"
}

fun displayHoursCorrect(value: Long) = when (value.asPlurals){
    Plurals.ONE -> "$value час"
    Plurals.FEW -> "$value часа"
    Plurals.MANY -> "$value часов"
}

fun displayDaysCorrect(value: Long) = when (value.asPlurals){
    Plurals.ONE -> "$value день"
    Plurals.FEW -> "$value дня"
    Plurals.MANY -> "$value дней"
}*/
