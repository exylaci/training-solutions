package week08.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringListsTest {
    @Test
    void shortestWordsTest() {
        List<String> required = List.of("aa", "bb", "dd");
        List<String> result = StringLists.shortestWords(List.of("aaa", "aa", "bb", "cccc", "dd"));

        assertEquals(required.size(), result.size());
        for (int i = 0; i < required.size(); ++i) {
            assertTrue(required.get(i).equals(result.get(i)));
        }
    }

    @Test
    void shortestWordsNullTest() {
        assertEquals(null, StringLists.shortestWords(null));
    }

    @Test
    void stringListsUnionTest() {
        List<String> required = List.of("aa", "hh", "bb", "cc", "dd", "ss", "kk");
        List<String> first = List.of("aa", "hh", "bb", "cc", "dd");
        List<String> second = List.of("ss", "aa", "dd", "kk", "bb");
        List<String> result = StringLists.stringListsUnion(first, second);

        assertEquals(required.size(), result.size());
        for (String one : required) {
            assertTrue(result.contains(one));
        }
    }
}