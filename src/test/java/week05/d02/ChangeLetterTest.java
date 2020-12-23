package week05.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {
    @Test
    void ChangeLetterTest() {

        assertEquals("*", new ChangeLetter().changeVowels("a"));
        assertEquals("*bcd*fgh*jklmn*pqrst*vwxyz",
                new ChangeLetter().changeVowels("abcdefghijklmnopqrstuvwxyz"));
        assertEquals("", new ChangeLetter().changeVowels(null));
        assertEquals("", new ChangeLetter().changeVowels(""));
    }
}