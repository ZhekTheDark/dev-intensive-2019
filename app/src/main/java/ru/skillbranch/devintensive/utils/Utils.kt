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
        //TODO() //кириллицу в латиницу
        return "исправь меня"
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