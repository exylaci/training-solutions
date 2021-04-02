package gyaxi.kovacseni.numberofdigits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberOfDigitsTest {

    @Test
    void testGetNumberOfDigitsEleven() {
        Assertions.assertEquals(13, new NumberOfDigits().getNumberOfDigits(11));
    }

    @Test
    void testGetNumberOfDigitsNegative() {
        Assertions.assertEquals(0, new NumberOfDigits().getNumberOfDigits(-11));
    }

    @Test
    void testGetNumberOfDigitsOne() {
        Assertions.assertEquals(1, new NumberOfDigits().getNumberOfDigits(1));
    }
}
