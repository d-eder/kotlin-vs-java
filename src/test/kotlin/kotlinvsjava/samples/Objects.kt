package kotlinvsjava.samples

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.format.DateTimeFormatter


// object singleton
object DateUtils {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    fun LocalDate.formatDate() = formatter
}

// top level function
private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
fun LocalDate.formatDate() = formatter


class SomeService {
    // companion object -> similar to static class  (class-level functions and properties)
    companion object {
        const val NAME = "KOTLIN"
    }

    object Factory {
        fun create() = SomeService()
    }

    fun sayHello(): String {
        return "Hello $NAME"
    }
}

class Test {
    @Test
    fun test() {
        val service = SomeService()
        val name = SomeService.NAME // class level property
        assertThat(service.sayHello()).isEqualTo("Hello $name")

        val service2 = SomeService.Factory.create()
    }
}
