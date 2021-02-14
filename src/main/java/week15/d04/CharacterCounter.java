package week15.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterCounter {

    public Map<CharType, Long> counterByChartype(Path path) {
        try (Stream<String> stringStream = Files.lines(path)) {
            return stringStream
                    .filter(a -> !a.isBlank())
                    .map(a -> a.toLowerCase(new Locale("hu", "HU")))
                    .flatMapToInt(String::chars)
                    .filter(CharType::isPrintable)
                    .mapToObj(CharType::getType)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + path);
        }
    }
}
//Számoljuk össze, hogy egy fájlban hány mássalhangzó, hány magánhangzó és hány egyéb karakter van.
// A space-eket ne vegyük figyelembe!
// A kis- és nagybetű különbség nem számít!