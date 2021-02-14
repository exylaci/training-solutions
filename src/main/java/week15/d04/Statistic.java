package week15.d04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statistic {
    public static final char SEPARATOR = ',';
    public static final char STRING_SIGN = '"';

    public List<StatisticResult> findMax3Cases(Path path, String country) {
        try (Stream<String> stringStream = Files.lines(path)) {

            return stringStream
                    .skip(1)
                    .filter(isNotBlank)
                    .map(this::processOneLine)
                    .filter(filterByCountryName(country))
                    .sorted(sortByCases)
                    .limit(3)
                    .peek(System.out::println)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + path);
        }
    }

    private final Comparator<StatisticResult> sortByCases = (a, b) -> (int) (b.getCases() - a.getCases());

    private final Predicate<String> isNotBlank = string -> !string.isBlank();

    private Predicate<StatisticResult> filterByCountryName(String country) {
        return statisticResult -> statisticResult.getCountry().equals(country);
    }

    private StatisticResult processOneLine(String oneLine) {
        List<String> result = new ArrayList<>();
        int previous = 0;
        boolean outOfAString = true;
        for (int i = 0; i < oneLine.length(); ++i) {
            if (outOfAString && oneLine.charAt(i) == SEPARATOR) {
                result.add(oneLine.substring(previous, i));
                previous = i + 1;
            }
            if (oneLine.charAt(i) == STRING_SIGN) {
                outOfAString = !outOfAString;
            }
        }
        result.add(oneLine.substring(previous));
        if (result.size() < 5) {
            return new StatisticResult();
        }
        return new StatisticResult(result.get(0), result.get(1), result.get(2), result.get(4));
    }
}
//Letölthetőek a koronavírus adatok innen: https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv
//Melyik három héten volt Magyarországon a legtöbb esetszám?