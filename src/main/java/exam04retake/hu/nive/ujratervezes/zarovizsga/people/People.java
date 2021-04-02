package exam04retake.hu.nive.ujratervezes.zarovizsga.people;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class People {
    public int getNumberOfMales(String path) {
        try (Stream<String> stream = Files.lines(Path.of(path), StandardCharsets.UTF_8)) {

            return (int) stream
                    .filter(IS_IT_MAN)
                    .count();

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + path, e);
        }
    }

    public static final Predicate<String> IS_IT_MAN = a -> a.contains(String.valueOf(",Male,"));

}
