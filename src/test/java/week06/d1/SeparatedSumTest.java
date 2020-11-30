package week06.d1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SeparatedSumTest {
    @Test
    public void separatedSumNullTest() {
        SeparatedSum s = new SeparatedSum();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                s.sum(null));
        assertEquals("Input string is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                s.sum(""));
        assertEquals("Input string is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                s.sum("1,3;2,4;-3,3;0-4.1"));
        assertEquals("Wrong format double string!", exception.getMessage());
    }

    @Test
    public void separatedSumTest() {
        SeparatedSum s = new SeparatedSum();
        assertEquals(new Sums(3.7, -7.4).toString(), s.sum("1,3;2,4;-3,3;0;-4.1").toString());
    }
}