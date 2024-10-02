package kotlinvsjava.samples;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SmartCastsJava {

    @Test
    void test() {
        assertThat(describe(List.of(1))).isEqualTo("Description: List of size 1");
    }

    String describe(Object obj) {
        String description;
        if (obj instanceof String) {
            String str = (String) obj;  // Manual cast to String
            description = "String of length " + str.length();
        } else if (obj instanceof Integer) {
            int num = (Integer) obj;  // Manual cast to Integer
            description = "Integer value: " + (num * 2);
        } else if (obj instanceof List) {
            List<?> list = (List<?>) obj;  // Manual cast to List
            description = "List of size " + list.size();
        } else {
            description = "Unknown type";
        }
        return "Description: " + description;
    }
}
