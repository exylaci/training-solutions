package gyaxi.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmallerWithTest {

    int[] numbers = {17, 103, -4, 5, 56, 7, 7, 99, 88, 3};

    @Test
    void smalerWithParameter1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new SmallerWith().smallerWith(-1, numbers)
        );
        assertEquals("Value is out of range!", exception.getMessage());
    }

    @Test
    void smalerWithParameter2() {
        Exception exception = assertThrows(IllegalStateException.class, () ->
                new SmallerWith().smallerWith(108, numbers)
        );
        assertEquals("There is no such number!", exception.getMessage());
    }

    @Test
    void smalerWithParameter3() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new SmallerWith().smallerWith(0)
        );
        assertEquals("Every parameter is a must!", exception.getMessage());
    }

    @Test
    void smalerWithParameter4() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new SmallerWith().smallerWith(0, null)
        );
        assertEquals("Every parameter is a must!", exception.getMessage());
    }

    @Test
    void smallerWith() {
        assertEquals(103, new SmallerWith().smallerWith(0, numbers));
        assertEquals(88, new SmallerWith().smallerWith(15, numbers));
        assertEquals(56, new SmallerWith().smallerWith(16, numbers));
        assertEquals(-4, new SmallerWith().smallerWith(107, numbers));
        assertEquals(2, new SmallerWith().smallerWith(5, 2, 1,17));
    }
}
