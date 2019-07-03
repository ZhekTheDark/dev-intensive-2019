package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //FIX ME , fix null and _

        /*return if (fullName == null || fullName?.trim() == "") Pair("John", "Doe")
        else if (fullName?.endsWith(" ") || !fullName?.contains(" ")) Pair("${fullName.trim()}", "Doe")
        else {
            val parts: List<String>? = fullName?.split(" ")

            val firstName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(1)

            Pair(firstName, lastName)
        }*/

        //Удаляем пробелы в начале и в конце

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
        //return firstName!![0].toUpperCase() + ". " + lastName!![0].toUpperCase() + "."
        return "исправь меня"
    }
}