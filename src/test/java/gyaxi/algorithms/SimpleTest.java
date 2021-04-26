package gyaxi.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTest {

    @Test
    void methodValidParameter() {
        String text = null;

        assertTrue(new Simple().method(text));
        assertFalse(new Simple().method(""));
        assertEquals(0, new Simple().method(7));
    }

    @Test
    void methodException() {
        Integer number = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Simple().method(number));
        assertEquals("Nem jó szám!", exception.getMessage());
    }
}