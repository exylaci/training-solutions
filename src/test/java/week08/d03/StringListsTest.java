package week08.d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListsTest {
    @Test
    void shortestWordsTest() {
        List<String> sample = List.of("aa", "bb", "dd");
        List<String> result = StringLists.shortestWords(List.of("aaa", "aa", "bb", "cccc", "dd"));

        assertEquals(sample.size(), result.size());
        for (int i = 0; i < sample.size(); ++i) {
            assertEquals(sample.get(i), result.get(i));
        }
    }
}