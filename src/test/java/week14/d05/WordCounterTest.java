package week14.d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void countWordsTest() {
        assertEquals(83, new WordCounter().countWords(Path.of("src/main/resources/week14/d05/hachiko.srt")));
    }
}