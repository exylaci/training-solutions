package gyaxi.kovacseni.uppercase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UpperCaseLettersTest {

    @Test
    void testGetNumberOfUpperCase() {
        Assertions.assertEquals(8, new UpperCaseLetters().getNumberOfUpperCase("characters.txt"));
    }

    @Test
    void testGetNumberOfUpperCaseHungarian() {
        Assertions.assertEquals(9, new UpperCaseLetters().getNumberOfUpperCase("characters_hun.txt"));
    }
}