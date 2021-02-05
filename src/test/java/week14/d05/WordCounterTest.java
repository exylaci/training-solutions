package week14.d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    @Test
    void countWordTest() {
        assertEquals(83, new WordCounter().countWord(Path.of("src/main/resources/week14/d05/hachiko.srt")));
    }

    @Test
    void countWordsTest() {
        WordCounter w = new WordCounter();
        System.out.println(w.countWords(Path.of("src/main/resources/week14/d05/hachiko.srt"),
           new String[]{"Hachiko","haza","pályaudvar","jó"}     ));

    }
}