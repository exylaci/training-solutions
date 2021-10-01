package exambemenetivizsga.longestword;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class LongestWord {
    public String findLongestWord(String fileName) {
        try (Stream<String> stream = Files.lines(Path.of(fileName))) {
            return stream
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .max(Comparator.comparingLong(String::length))
                    .orElse("");
        } catch (IOException e) {
            return "";
        }
    }
}