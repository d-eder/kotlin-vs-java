package kotlinvsjava

import org.apache.commons.lang3.StringUtils

fun main() {
    val input = "  hello world  "
    // Trim and capitalize the string using Apache Commons Lang
    val result = StringUtils.capitalize(StringUtils.trim(input))
    println("Transformed string: '$result'")
}