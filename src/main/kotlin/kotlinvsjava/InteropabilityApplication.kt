package kotlinvsjava

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@SpringBootApplication
class InteroperabilityApplication

fun main(args: Array<String>) {
    runApplication<InteroperabilityApplication>(*args)
}

@Component
class HelloWorldRunner(private val javaService: JavaService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println(javaService.sayHello())
    }
}