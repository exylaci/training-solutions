package week15.d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statistic {
    Map<String, Integer> countries = new HashMap<>();

    public List<Result> maxCasesPerPerson(Path path) {
        try (Stream<String> stringStream = Files.lines(path)) {
            return stringStream
                    .skip(1)
                    .map(this::processOnLine)
                    .map(this::convertToData)
                    .collect(Collectors.groupingBy(Data::getCountry, Collectors.summingInt(Data::getCases)))
                    .entrySet()
                    .stream()
                    .filter(this::checkPopulation)
                    .map(this::divideByPopulation)
                    .sorted()
//                    .peek(System.out::println)
                    .limit(3)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file");
        }
    }

    private boolean checkPopulation(Map.Entry<String, Integer> countryCases) {
        return countries.containsKey(countryCases.getKey()) && countries.get(countryCases.getKey()) > 0;
    }

    private Result divideByPopulation(Map.Entry<String, Integer> countryCases) {
        return new Result(
                countryCases.getKey(),
                ((double) countryCases.getValue()) / countries.get(countryCases.getKey()));
    }

    private Data convertToData(List<String> strings) {
        Data data = new Data(strings);
        if (data.getPopulation() > 0) {
            countries.putIfAbsent(data.getCountry(), data.getPopulation());
        }
        return data;
    }

    private List<String> processOnLine(String oneLine) {
        List<String> result = new ArrayList<>();

        boolean outOfAString = true;
        int previous = 0;
        for (int i = 0; i < oneLine.length(); ++i) {
            if (oneLine.charAt(i) == '"') {
                outOfAString = !outOfAString;
            }
            if (outOfAString && oneLine.charAt(i) == ',') {
                result.add(oneLine.substring(previous, i));
                previous = i + 1;
            }
        }
        result.add(oneLine.substring(previous));

        return result;
    }
}
//Letölthetőek a COVID adatok a
//https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv
//címről.Összegezd országonként az esetszámokat, és add vissza azt a három
//országot, ahol az összes esetszám populációra arányosítva a legnagyobb.