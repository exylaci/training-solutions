package gyaxi.kovacseni.sumofdigits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SumOfDigitsTest {

    @Test
    public void getSumOfDigits() {
        Assertions.assertEquals(9, new SumOfDigits().getSumOfDigits(new Random(1)));
    }
}