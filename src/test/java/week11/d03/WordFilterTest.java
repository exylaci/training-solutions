package week11.d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    void wordsWithCharTest() {
        WordFilter w = new WordFilter();
        assertEquals(Collections.emptyList(), w.wordsWithChar(null, 'c'));
        assertEquals(Collections.emptyList(), w.wordsWithChar(new ArrayList<>(), 'c'));

        List<String> temp = new ArrayList<>();
        temp.add(null);
        assertEquals(Collections.emptyList(), w.wordsWithChar(temp, 'c'));

        assertEquals(Collections.emptyList(), w.wordsWithChar(List.of("a", "b", "c"), 'd'));

        List<String> result = w.wordsWithChar(List.of("abc", "bcd", "cde", "def"), 'd');
        assertEquals(3, result.size());
        assertEquals("bcd", result.get(0));
    }
}