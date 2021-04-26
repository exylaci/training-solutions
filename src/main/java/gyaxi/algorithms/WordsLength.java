package gyaxi.algorithms;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordsLength {
    public static final String NON_LETTER_CHARACTERS = "[ ,\\.!\\?:\"]";

    public Map<Integer, Integer> getStatistic(String... text) {
        if (text == null || text.length < 1) {
            throw new IllegalArgumentException("The parameter is a must!");
        }

        return Arrays.stream(text)
                .filter(line -> line != null)
                .flatMap((String line) -> Arrays.stream(line.split(NON_LETTER_CHARACTERS)))
                .filter(word -> word.length() > 0)
                .collect(Collectors.toMap(String::length, len -> 1, Integer::sum));
    }
}
//Add vissza, hogy a kapott szövegben az különböző hosszúságú szavakból hány-hány darab van.
//Az írásjelek nem számítanak a szavak hosszához!