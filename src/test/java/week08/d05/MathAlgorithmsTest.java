package week08.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathAlgorithmsTest {
    @Test
    void greatestCommonDivisorTest(){
        assertEquals(5,MathAlgorithms.greatestCommonDivisor(105,95));
    }

    @Test
    void greatestCommonDivisorParameter1Test(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                MathAlgorithms.greatestCommonDivisor(0,95));
        assertEquals("Only positive numbers are accepted!",exception.getMessage());
    }

    @Test
    void greatestCommonDivisorParameter2Test(){
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                MathAlgorithms.greatestCommonDivisor(1,0));
        assertEquals("Only positive numbers are accepted!",exception.getMessage());
    }
}
