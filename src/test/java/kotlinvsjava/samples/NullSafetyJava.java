package kotlinvsjava.samples;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NullSafetyJava {
    @Test
    void test() {
        String x = null;
        System.out.println(x.length());
        new Person().getNameLength();
    }

    static class Person {
        private String name;

        public int getNameLength() {
            return name.length();
        }
    }
}