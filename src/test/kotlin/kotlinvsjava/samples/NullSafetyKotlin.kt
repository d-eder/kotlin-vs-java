package kotlinvsjava.samples

import org.junit.jupiter.api.Test

class NullSafetyKotlin {

    @Test
    fun test(){
        val x: String? = null
        // println(x.length) // -> compile issue
        println(x?.length)

    }

    class Person{
        val name: String = "Max"

        fun getNameLength(): Int {
            return name.length
        }
    }
}