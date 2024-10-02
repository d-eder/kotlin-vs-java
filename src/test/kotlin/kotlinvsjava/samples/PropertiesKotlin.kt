package kotlinvsjava.samples

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

class PropertiesKotlin() {

    fun testPerson() {
        val person = PersonEntity(firstName = "Max", lastName = "Mustermann")
        val updatedPerson = person.apply {
            firstName = "Max2"
            birthDate = LocalDate.of(1990, 1, 1)
            // id = 2 // compile issue
        }

        // type inference
        updatedPerson.age.toByte()
    }

    // mandatory fields in constructor
    // no setter for id
    @Entity
    class PersonEntity( // primary constructor
        @NotNull
        @Column
        var firstName: String,

        @NotNull
        @Column
        var lastName: String,

        @NotNull
        @Column
        var age: Int = 18
    ) {
        @Column
        var birthDate: LocalDate? = null

        @Id
        val id: Int = 0
    }
}
