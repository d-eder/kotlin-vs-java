package kotlinvsjava;

import kotlinvsjava.NameProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JavaService {
    private final NameProvider nameProvider;

    public String sayHello() {
        return "Hello " + nameProvider.getName();
    }
}
