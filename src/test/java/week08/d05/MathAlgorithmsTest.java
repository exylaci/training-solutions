package week08.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {
    @Test
    void greatestCommonDivisorTest() {
        assertEquals(5, MathAlgorithms.greatestCommonDivisor(105, 95));
        assertEquals(10, MathAlgorithms.greatestCommonDivisor(20, 30));
        assertEquals(36, MathAlgorithms.greatestCommonDivisor(504, 540));
    }

    @Test
    void greatestCommonDivisorWithPrimsTest() {
        assertEquals(5, MathAlgorithms.legnagyobbKozosOsztoPrimTenyezokkel(105, 95));
        assertEquals(10, MathAlgorithms.legnagyobbKozosOsztoPrimTenyezokkel(20, 30));
        assertEquals(36, MathAlgorithms.legnagyobbKozosOsztoPrimTenyezokkel(504, 540));
    }

    @Test
    void greatestCommonDivisorParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                MathAlgorithms.greatestCommonDivisor(0, 95));
        assertEquals("Only positive numbers are accepted!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                MathAlgorithms.greatestCommonDivisor(1, 0));
        assertEquals("Only positive numbers are accepted!", exception.getMessage());
    }
}