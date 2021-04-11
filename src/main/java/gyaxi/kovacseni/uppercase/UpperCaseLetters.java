package gyaxi.kovacseni.uppercase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class UpperCaseLetters {
    public Long getNumberOfUpperCase(String filename) {
        try (Stream<String> stream = Files.lines(
                Path.of("src/main/resources/gyaxi/kovacseni/uppercase").resolve(filename), StandardCharsets.UTF_8)) {

            return stream
                    .flatMapToInt(String::chars)
                    .filter(this::isUppercase)
                    .count();

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + filename, e);
        }
    }

    private boolean isUppercase(int value) {
        String string = String.valueOf((char) value);
        return !string.toLowerCase().equals(string);
    }
}
