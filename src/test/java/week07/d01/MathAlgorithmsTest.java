package week07.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathAlgorithmsTest {
    @Test
    public void isPrim1Test() {
        assertTrue(MathAlgorithms.isPrim(2));
        assertFalse(MathAlgorithms.isPrim(4));
        assertFalse(MathAlgorithms.isPrim(841));
        assertTrue(MathAlgorithms.isPrim(839));
    }

    @Test
    public void isPrim2Test() {
        assertTrue(MathAlgorithms.isPrim(2L));
        assertFalse(MathAlgorithms.isPrim(4L));
        assertFalse(MathAlgorithms.isPrim(841L));
        assertTrue(MathAlgorithms.isPrim(839L));
    }

    @Test
    void isPrim1WrongParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                MathAlgorithms.isPrim(0));
        assertEquals("Csak pozitív egész szám!", exception.getMessage());
    }

    @Test
    void isPrim2WrongParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                MathAlgorithms.isPrim(0L));
        assertEquals("Csak pozitív egész szám!", exception.getMessage());
    }
}