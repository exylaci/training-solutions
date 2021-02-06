package week14.d05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    public Map<String, Long> countWords(Path path, String[] words) {

        List<String> wordsInList = Arrays.asList(words);
        try (Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8)) {
            return stream
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(wordsInList::contains)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            //Az írásjelek miatt nem számol meg minden esetet. Ezeket előbb törölni kellene a szevak mögűl.

        } catch (IOException e) {
            throw new IllegalStateException("Can't read the file!");
        }
    }

    public int countWord(Path parh) {
        try (Stream<String> stream = Files.lines(parh, StandardCharsets.UTF_8)) {
            return (int) stream
                    .filter(oneLine -> oneLine.contains("Hach"))
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .filter(word -> word.contains("Hach"))
                    .count();

        } catch (IOException e) {
            throw new IllegalStateException("Can't read the file!");
        }
    }
}
//A examples/week14d05/hachiko.srt van a Hachiko film felirata. Írj egy
//countWords() metódust, mely paraméterül várja a fájlt, varargsban szavakat. Megszámolja, hogy melyik szó hány sorban
//szerepel a szövegben. Legyenek mondjuk a beadott szavak:
// "Hachiko", "haza", "pályaudvar", "jó"
//
//Csak streamek használatával számold ki, hogy hányszor hangzik el a kutya neve a filmben!
// Segítség: a Files.lines() adja vissza a fájl sorait streamben.