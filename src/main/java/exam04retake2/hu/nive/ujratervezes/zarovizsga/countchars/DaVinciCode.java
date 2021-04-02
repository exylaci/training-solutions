package exam04retake2.hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DaVinciCode {

    public static final String VALID_INPUTS = "01x";

    public int encode(String path, char c) {
        if (!VALID_INPUTS.contains(String.valueOf(c))) {
            throw new IllegalArgumentException("Invalid character: " + c);
        }

        try (Stream<String> line = Files.lines(Path.of(path))) {

            return (int) line
                    .flatMapToInt(String::chars)
                    .filter(a -> ((char) a) == c)
                    .count();

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read the file: " + path, e);
        }
    }
}
