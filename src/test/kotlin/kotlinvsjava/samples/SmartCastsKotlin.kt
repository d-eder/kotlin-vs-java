package kotlinvsjava.samples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SmartCastsKotlin {
    @Test
    fun test(){
        assertThat(describe(listOf(1))).isEqualTo("Description: List of size 1")
    }

    fun describe(obj: Any): String {
        val description = when (obj) {
            is String -> "String of length ${obj.length}" // Smart cast to String
            is Int -> "Integer value: ${obj * 2}" // Smart cast to Int
            is List<*> -> "List of size ${obj.size}" // Smart cast to List
            else -> "Unknown type"
        }
        // String Template
        return "Description: $description"
    }

    @Test
    fun stringTemplate(){
        val nr = 3
        val string = "Number: $nr"
        assertThat(string).isEqualTo("Number: 3")

        val string2 = "String length: ${string.length}"
        val multiLine = """
            Multi
            Line
        """.trimIndent()
    }
}