package kotlinvsjava.samples;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

public class PropertiesJava {

    void testPerson(){
        var person = new PersonEntity("Max", "Mustermann");
        person.setFirstName("Max2");
        person.setBirthDate(LocalDate.of(1990, 1, 1));
    }

    void testLombokPerson(){
        var person = new LombokPersonEntity("Max", "Mustermann");
        person.setFirstName("Max2");
        person.setBirthDate(LocalDate.of(1990, 1, 1));

        ((Integer)person.getAge()).byteValue();
    }

    @Entity
    static class PersonEntity{
        @Id
        private int id;

        @Column
        @NotNull
        private String firstName;

        @Column
        @NotNull
        private String lastName;

        @Column
        private LocalDate birthDate;

        public PersonEntity(){}

        public PersonEntity(@NotNull String firstName, @NotNull String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        @NotNull
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(@NotNull String firstName) {
            this.firstName = firstName;
        }

        @NotNull
        public String getLastName() {
            return lastName;
        }

        public void setLastName(@NotNull String lastName) {
            this.lastName = lastName;
        }

        public LocalDate getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
        }
    }

    @NoArgsConstructor
    @RequiredArgsConstructor
    @Getter
    @Entity
    static class LombokPersonEntity{
        @Id
        private int id;

        @Column
        @NotNull
        @NonNull
        @Setter
        private String firstName;

        @Column
        @NotNull
        @NonNull
        @Setter
        private String lastName;

        @Column
        @Setter
        private LocalDate birthDate;

        @Column
        @NotNull
        @NonNull
        @Setter
        private int age = 18;
    }
}
