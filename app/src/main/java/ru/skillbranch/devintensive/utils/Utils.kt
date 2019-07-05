package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val fullNameTrimmed = fullName?.trimStart()?.trimEnd()

        if (fullNameTrimmed == "") return null to null

        val parts: List<String>? = fullNameTrimmed?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var res = ""

        for (element in payload) {
            when {
                element.toLowerCase() == ' ' -> res += divider
                element.toLowerCase().toString() in vocabulary -> res +=
                    if (element.isUpperCase()) vocabulary[element.toLowerCase().toString()]?.capitalize()
                    else vocabulary[element.toString()]
                else -> res += element
            }
        }

        return res
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstNameTrimmed = firstName?.trim()
        val lastNameTrimmed = lastName?.trim()

        return when {
            firstNameTrimmed.isNullOrEmpty() && lastNameTrimmed.isNullOrEmpty() -> null
            firstNameTrimmed.isNullOrEmpty() -> "${lastNameTrimmed!![0].toUpperCase()}"
            lastNameTrimmed.isNullOrEmpty() -> "${firstNameTrimmed!![0].toUpperCase()}"
            else -> "${firstNameTrimmed!![0].toUpperCase()}${lastNameTrimmed!![0].toUpperCase()}"
        }
    }
}

val vocabulary = mapOf(
    "а" to "a",
    "б" to "b",
    "в" to "v",
    "г" to "g",
    "д" to "d",
    "е" to "e",
    "ё" to "e",
    "ж" to "zh",
    "з" to "z",
    "и" to "i",
    "й" to "i",
    "к" to "k",
    "л" to "l",
    "м" to "m",
    "н" to "n",
    "о" to "o",
    "п" to "p",
    "р" to "r",
    "с" to "s",
    "т" to "t",
    "у" to "u",
    "ф" to "f",
    "х" to "h",
    "ц" to "c",
    "ч" to "ch",
    "ш" to "sh",
    "щ" to "sh'",
    "ъ" to "",
    "ы" to "i",
    "ь" to "",
    "э" to "e",
    "ю" to "yu",
    "я" to "ya"
)