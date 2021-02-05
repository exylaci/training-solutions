package week14.d05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WordCounter {
    public int countWords(Path parh) {
        try {
            return (int) Files
                    .lines(parh, StandardCharsets.UTF_8)
                    .filter(oneLine -> oneLine.contains("Hachiko")||oneLine.contains("Hachi"))
                    .count();
        } catch (IOException e) {
            throw new IllegalStateException("Can't read the file!");
        }
    }
}
