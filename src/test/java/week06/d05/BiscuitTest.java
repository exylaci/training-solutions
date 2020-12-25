package week06.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiscuitTest {
    @Test
    void ofTest() {
        Biscuit biscuit = Biscuit.of(BiscuitType.DANISH_BUTTER_COOKIES, 250);
        assertEquals(BiscuitType.DANISH_BUTTER_COOKIES, biscuit.getBiscuitType());
        assertEquals(250, biscuit.getGramAmount());
    }

    @Test
    void toStringTest() {
        Biscuit biscuit = Biscuit.of(BiscuitType.DANISH_BUTTER_COOKIES, 250);
        assertEquals("Biscuit type: DANISH_BUTTER_COOKIES amount: 250 gramm", biscuit.toString());
    }
}
