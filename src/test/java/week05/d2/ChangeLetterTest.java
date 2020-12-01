package week05.d2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {
    @Test
    void ChangeLetterTest() {
        
        assertEquals("*bcd*fgh*jklmn*pqrst*vwxyz", new ChangeLetter().chhangeVowels("abcdefghijklmnopqrstuvwxyz"));
        assertEquals("", new ChangeLetter().chhangeVowels(null));
        assertEquals("", new ChangeLetter().chhangeVowels(""));
        assertEquals("*", new ChangeLetter().chhangeVowels("a"));
    }
}
