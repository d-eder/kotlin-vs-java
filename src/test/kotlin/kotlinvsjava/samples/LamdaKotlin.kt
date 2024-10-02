package kotlinvsjava.samples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

//Lambda expressions and inline functions
class LambdaKotlin {
    @Test
    fun testFilter() {
        val list = listOf("Tom", "Bob")
        val filteredList = list.filterCaseInsensitive { it.contains("bo") }
        // map is an inline function
        val names = filteredList.map { Name(it) }
        assertThat(names).containsExactly(Name("Bob"))
    }

    // extension function
    private fun List<String>.filterCaseInsensitive(predicate: (String) -> Boolean): List<String> {
        return this.filter { predicate(it.lowercase()) }
    }

    // data class
    data class Name(val name: String)


    @Test
    fun testCopy(){
        val person = PersonDto("Max", 18)
        val copied = person.copy(age = 20)
        assertThat(copied).isEqualTo(PersonDto("Max",20))
    }
    data class PersonDto(val name: String, val age: Int)
}

