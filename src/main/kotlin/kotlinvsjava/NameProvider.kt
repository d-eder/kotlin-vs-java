package kotlinvsjava

import org.springframework.stereotype.Service

@Service
class NameProvider {
    fun getName() = "Kotlin"
}