package exam04_zarovizsga.hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class WorkHours {

    public String minWork(String path) {
        try (Stream<String> stream = Files.lines(Path.of(path), StandardCharsets.UTF_8)) {

            return stream
                    .filter(CONTAINS_THE_SEPARATOR)
                    .min(basedOnWorkHours)
                    .map(this::convertToReportFormat)
                    .orElseThrow(() -> new IllegalArgumentException("No one was working!"));

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + path, e);
        }
    }

    public static final char SEPARATOR = ',';

    public static final Predicate<String> CONTAINS_THE_SEPARATOR = a -> a.contains(String.valueOf(SEPARATOR));


    private final Comparator<String> basedOnWorkHours = Comparator.comparingInt(this::getWorkHours);

    private int getWorkHours(String line) {
        return Integer.parseInt(line.substring(line.indexOf(SEPARATOR) + 1, line.lastIndexOf(SEPARATOR)));
    }


    private String convertToReportFormat(String line) {
        return line.substring(0, line.indexOf(SEPARATOR)) +
                ": " +
                line.substring(line.lastIndexOf(SEPARATOR) + 1);
    }
}
