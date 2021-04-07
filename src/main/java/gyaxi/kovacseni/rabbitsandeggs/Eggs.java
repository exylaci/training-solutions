package gyaxi.kovacseni.rabbitsandeggs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public class Eggs {
    public Rabbit getRabbitWithMaxEggs() {
        try (Stream<String> stream = Files.lines(
                Path.of("src/main/resources/gyaxi/kovacseni/rabbitsandeggs/eggs.csv"), StandardCharsets.UTF_8)) {

            return stream
                    .map(Rabbit::of)
                    .max(Comparator.comparing(Rabbit::getEggs))
                    .orElseThrow(() -> new IllegalStateException("There is no working rabbit at all."));

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file", e);
        }
    }
}
