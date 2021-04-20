package gyaxi.kovacseni.digits;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DigitsTest {

    @Test
    public void testGetNumbers() {
        Assertions.assertEquals(9, new Digits().getNumbers());
    }
}
