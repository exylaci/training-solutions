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

public class WordCounter {
    public Map<String , Long> countWords(Path path, String[] words){
        List<String> wordsInList = Arrays.asList(words);
        try {
            return Files
                    .lines(path, StandardCharsets.UTF_8)
                    .flatMap(line -> Arrays.stream(line.split(" ").clone()))
                    .filter(word->wordsInList.contains(word))
                    .collect( Collectors.groupingBy(Function.identity(), Collectors.counting()));
        } catch (IOException e) {
            throw new IllegalStateException("Can't read the file!");
        }
    }

    public int countWord(Path parh) {
        try {
            return (int) Files
                    .lines(parh, StandardCharsets.UTF_8)
                    .filter(oneLine -> oneLine.contains("Hachiko"))
                    .count();
        } catch (IOException e) {
            throw new IllegalStateException("Can't read the file!");
        }
    }
}
