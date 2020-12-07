package week07.d1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathAlgoritmusTest {
    @Test
    public void isPrimTest(){
        assertFalse(MathAlgoritmus.isPrim(1));
        assertTrue(MathAlgoritmus.isPrim(2));
        assertFalse(MathAlgoritmus.isPrim(12));
        assertTrue(MathAlgoritmus.isPrim(13));
    }
    @Test
    void isPrimWrongParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                MathAlgoritmus.isPrim(0));
        assertEquals("Pozitív egész szám kell!", exception.getMessage());
    }
}
