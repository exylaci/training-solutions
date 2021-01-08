package week10.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void findMinMaxSumTest() {
        Calculator c = new Calculator();

        assertEquals(0, c.findMinMaxSum(null).getMin());
        assertEquals(4, c.findMinMaxSum(new int[]{4}).getMin());
        assertEquals(-4, c.findMinMaxSum(new int[]{-4}).getMin());
        assertEquals(10, c.findMinMaxSum(new int[]{1,2,3,4}).getMin());
        assertEquals(24, c.findMinMaxSum(new int[]{8,9,2,5,13,222}).getMin());
        assertEquals(-10, c.findMinMaxSum(new int[]{-1,-2,-3,-4,}).getMin());
        assertEquals(-207, c.findMinMaxSum(new int[]{8,9,2,5,13,-222}).getMin());

        assertEquals(0, c.findMinMaxSum(null).getMax());
        assertEquals(4, c.findMinMaxSum(new int[]{4}).getMax());
        assertEquals(-4, c.findMinMaxSum(new int[]{-4}).getMax());
        assertEquals(10, c.findMinMaxSum(new int[]{1,2,3,4}).getMax());
        assertEquals(252, c.findMinMaxSum(new int[]{8,9,2,5,13,222}).getMax());
        assertEquals(-10, c.findMinMaxSum(new int[]{-1,-2,-3,-4,}).getMax());
        assertEquals(35, c.findMinMaxSum(new int[]{8,9,2,5,13,-222}).getMax());
    }
}
