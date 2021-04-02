package gyaxi.kovacseni.dogs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DogManager {

    public static final String SOURCE_PATH = "src/main/resources/gyaxi/kovacseni/dogs/dogs.csv";
    public static final String FILE_ERROR_MESSAGE = "Cannot read from file";
    public static final String SEARCH_ERROR_MESSAGE = "No such dog name found.";

    public String getCountryByExactDogSpecies(String name) {
        try (Stream<String> stream = Files.lines(Path.of(SOURCE_PATH), StandardCharsets.UTF_8)) {

            String findIt = name.toUpperCase();
            return stream
                    .skip(1)
                    .map(Dog::fromString)
                    .filter(dog -> dog.getName().equals(findIt))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException(SEARCH_ERROR_MESSAGE))
                    .getCountry();

        } catch (IOException e) {
            throw new IllegalStateException(FILE_ERROR_MESSAGE, e);
        }
    }

    public List<Dog> getDogsInAlphabeticalOrderByName() {
        try (Stream<String> stream = Files.lines(Path.of(SOURCE_PATH), StandardCharsets.UTF_8)) {

            return stream
                    .skip(1)
                    .map(Dog::fromString)
                    .sorted(Comparator.comparing(Dog::getName))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            throw new IllegalStateException(FILE_ERROR_MESSAGE, e);
        }
    }

    public Map<String, Integer> getDogStatistics() {
        try (Stream<String> stream = Files.lines(Path.of(SOURCE_PATH), StandardCharsets.UTF_8)) {

            return stream
                    .skip(1)
                    .map(Dog::fromString)
                    .collect(Collectors.toMap(
                            Dog::getCountry,
                            piece -> 1,
                            Integer::sum));

//                  .collect(Collectors.groupingBy(Dog::getCountry,Collectors.counting()));
//                  Ez nem lenne jó, mert Map<String, Integert> vár és nem Map<String, Long> -ot!

        } catch (IOException e) {
            throw new IllegalStateException(FILE_ERROR_MESSAGE, e);
        }
    }
}