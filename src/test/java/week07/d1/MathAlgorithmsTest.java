package week07.d1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathAlgorithmsTest {
    @Test
    public void isPrimTest() {
        assertFalse(new MathAlgorithms().isPrim(841));
        assertTrue(new MathAlgorithms().isPrim(839));
    }

    @Test
    void isPrimWrongParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new MathAlgorithms().isPrim(0));
        assertEquals("Csak pozitív egész szám!", exception.getMessage());
    }
}