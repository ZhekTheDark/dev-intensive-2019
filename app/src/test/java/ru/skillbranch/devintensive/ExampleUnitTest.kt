package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.models.*
import ru.skillbranch.devintensive.utils.*

import java.util.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Сena")
    }

    @Test
    fun test_factory() {
//        val user = User.makeUser("John Cena")
//        val user2 = User.makeUser("John Wick")
        val user = User.makeUser("John Silverhand")
        val user3 = user.copy("2", lastName = "Cena", lastVisit = Date())

        println("$user \n$user3")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
        println("${user.id}, ${user.firstName}, ${user.lastName}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_dataq_maping() {
        /*val user0 = User.makeUser(null)
        println(user0)
        val userView0 = user0.toUserView()
        userView0.printMe()
        println()
        println() //null null

        val user1 = User.makeUser("")
        println(user1)
        val userView1 = user1.toUserView()
        userView1.printMe()
        println()
        println() // "" null

        val user2 = User.makeUser(" ")
        println(user2)
        val userView2 = user2.toUserView()
        userView2.printMe()
        println()
        println() // "" ""

        val user3 = User.makeUser("Евгений Бобруцков")
        println(user3)
        val userView3 = user3.toUserView()
        userView3.printMe()
        println()
        println() // Евгений Бобруцков

        val user4 = User.makeUser("Евгений ")
        println(user4)
        val userView4 = user4.toUserView()
        userView4.printMe()
        println()
        println() // Евгений ""

        val user5 = User.makeUser("Евгений")
        println(user5)
        val userView5 = user5.toUserView()
        userView5.printMe()
        println()
        println() // Евгений null*/

        println("${Utils.parseFullName("John Doe")}")
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Евгений Бобруцков")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }

    @Test
    fun test_of_parseFullName(){
        assertEquals(null to null, Utils.parseFullName(null))
        assertEquals(null to null, Utils.parseFullName(""))
        assertEquals(null to null, Utils.parseFullName(" "))
        assertEquals("John" to null, Utils.parseFullName("John"))
        assertEquals(null to null, Utils.parseFullName("    "))
        assertEquals("John" to null, Utils.parseFullName("John "))
        assertEquals("John" to null, Utils.parseFullName("  John "))
    }

    @Test
    fun test_of_toInitials() {
        assertEquals("JD",  Utils.toInitials("john" ,"doe") )
        assertEquals("J",  Utils.toInitials("John", null) )
        assertEquals("D",  Utils.toInitials(null, "doe") )
        assertEquals(null,  Utils.toInitials(null, null) )
        assertEquals(null,  Utils.toInitials(" ", "") )
    }

    @Test
    fun test_of_transliteration() {

        println(  Utils.transliteration("Чингиз Байшурин") )
        println(  Utils.transliteration("Натан Щарянский Самуилович", "_") )
        assertEquals( "Chingiz Baishurin", Utils.transliteration("Чингиз Байшурин") )
        assertEquals( "Ivan Stereotipov", Utils.transliteration("Иван Стереотипов") )
        assertEquals( "Amazing_Petr", Utils.transliteration("Amazing Петр", divider = "_") )

        assertEquals( "Zh Zh", Utils.transliteration("Ж Ж") )
        assertEquals( "ZhZh", Utils.transliteration("ЖЖ") )
        assertEquals( "AbrAKadabra", Utils.transliteration("AbrAKadabra") )
        assertEquals( "StraNNIi NikVash'e", Utils.transliteration("СтраННЫй НикВаще") )
    }
}

