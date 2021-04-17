package gyaxi.kovacseni.sleepingbeauty;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SleepingBeauty {
    private static final String LETTERS = "áéíóöőúüű";

    public Map<Character, Integer> countCharacters(String fileName) {
        try (Stream<String> stream = Files.lines(
                Path.of("src/main/resources/gyaxi/kovacseni/sleepingbeauty").resolve(fileName), StandardCharsets.UTF_8)) {

            return stream
                    .map(String::toLowerCase)
                    .flatMapToInt(String::chars)
                    .boxed()
                    .map(i -> (char) ((int) i))
                    .filter(this::isLetter)
                    .collect(Collectors.toMap(Function.identity(), t -> 1, Integer::sum));

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + fileName, e);
        }
    }

    private boolean isLetter(char value) {
        if (LETTERS.contains(Character.toString(value)) || value >= 'a'  && value <= 'z') {
            return true;
        }
        return false;
    }
}
