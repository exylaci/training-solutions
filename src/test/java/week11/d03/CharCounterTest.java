package week11.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharCounterTest {

    @Test
    void countCharsTest() {
        CharCounter c = new CharCounter();
        assertEquals(0, c.countChars(null));
        assertEquals(0, c.countChars(new String[]{null}));
        assertEquals(0, c.countChars(new String[]{"abcd"}));
        assertEquals(0, c.countChars(new String[]{"abcd", null, "abcd"}));
        assertEquals(0, c.countChars(new String[]{"abcd", "efgh", "ijkl"}));
        assertEquals(2, c.countChars(new String[]{"abcd", "efgbcdh", "iabcjkl"}));
        assertEquals(3, c.countChars(new String[]{"abcabcabcabc", "abc", "abc"}));
        assertEquals(1, c.countChars(new String[]{"aaaaaaaaaaa", "aaaaaaa", "aaaa"}));
    }
}