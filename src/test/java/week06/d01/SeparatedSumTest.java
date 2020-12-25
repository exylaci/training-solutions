package week06.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeparatedSumTest {
    @Test
    public void separatedSumTest() {
        assertEquals(new Sums(3.7, -7.4).toString(), SeparatedSum.separatedSums("1,3;2,4;-3,3;0;-4.1").toString());
    }

    @Test
    public void separatedSumParameterTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                SeparatedSum.separatedSums(null));
        assertEquals("Input string is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                SeparatedSum.separatedSums(""));
        assertEquals("Input string is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                SeparatedSum.separatedSums("1,3;2,4;-3,3;0-4.1"));
        assertEquals("Wrong format double string!", exception.getMessage());
    }
}