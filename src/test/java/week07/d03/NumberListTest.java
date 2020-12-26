package week07.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NumberListTest {
    @Test
    void isIncreasingTest() {

        assertTrue(NumberList.isIncreasing(List.of(1, 2, 5, 5, 7, 9, 12, 56, 99)));
        assertFalse(NumberList.isIncreasing(List.of(1, 2, 5, 5, 7, 9, 56, 12, 99)));

        assertTrue(NumberList.isIncreasing(List.of(1)));

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                NumberList.isIncreasing(List.of()));
        assertEquals("The list is empty!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                NumberList.isIncreasing(null));
        assertEquals("The list is empty!", exception.getMessage());
    }
}