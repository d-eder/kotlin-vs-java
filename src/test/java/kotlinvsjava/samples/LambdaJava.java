package kotlinvsjava.samples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaJava {
    @Test()
    void testFilter() {
        var list = List.of("Tom", "Bob");
        var filteredList = filterCaseInsensitive(list, name -> name.contains("bo"));
        var names = filteredList.stream().map(Name::new);
        assertThat(names).containsExactly(new Name("Bob"));
    }

    private static List<String> filterCaseInsensitive(List<String> list, Predicate<String> predicate) {
        return list
                .stream()
                .filter(entry -> predicate.test(entry.toLowerCase()))
                .toList();
    }

    record Name(String name) {
    }
}
