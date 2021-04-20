package gyaxi.kovacseni.finelongword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FineLongWordTest {

    private FineLongWord flw = new FineLongWord();

    @Test
    public void testReadFineLongWordFromFileAndGetItInAnArrayWithFirstWord() {
        char[] expected = flw.readFineLongWordFromFileAndGetItInAnArray("longword1.txt");

        Assertions.assertEquals(18, expected.length);
        Assertions.assertEquals('A', expected[2]);
        Assertions.assertEquals('W', expected[12]);
    }

    @Test
    public void testReadFineLongWordFromFileAndGetItInAnArrayWithSecondWord() {
        char[] expected = flw.readFineLongWordFromFileAndGetItInAnArray("longword2.txt");

        Assertions.assertEquals(29, expected.length);
        Assertions.assertEquals('P', expected[4]);
        Assertions.assertEquals('X', expected[21]);
    }

    @Test
    public void testReadFineLongWordFromFileAndGetItInAnArrayWithThirdWord() {
        char[] expected = flw.readFineLongWordFromFileAndGetItInAnArray("longword3.txt");

        Assertions.assertEquals(17, expected.length);
        Assertions.assertEquals('I', expected[3]);
        Assertions.assertEquals('C', expected[15]);
    }
}