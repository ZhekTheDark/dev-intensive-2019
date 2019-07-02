package ru.skillbranch.devintensive.Utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //FIX ME , fix null and _
        return if (fullName == null || fullName?.trim() == "") Pair("John", "Doe")
        else if (fullName?.endsWith(" ") || !fullName?.contains(" ")) Pair("${fullName.trim()}", "Doe")
        else {
            val parts: List<String>? = fullName?.split(" ")

            val firstName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(1)

            Pair(firstName, lastName)
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        //TODO() //кириллицу в латиницу
        return "исправь меня"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return firstName!![0].toUpperCase() + ". " + lastName!![0].toUpperCase() + "."
    }
}