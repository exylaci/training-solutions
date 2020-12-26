package week09.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibCalculatorTest {
    @Test
    void sumEventsTest() {
        assertEquals(0, FibCalculator.sumEvents(0));
        assertEquals(0, FibCalculator.sumEvents(1));
        assertEquals(2, FibCalculator.sumEvents(2));
        assertEquals(2, FibCalculator.sumEvents(3));
        assertEquals(2, FibCalculator.sumEvents(7));
        assertEquals(10, FibCalculator.sumEvents(8));
        assertEquals(10, FibCalculator.sumEvents(22));
        assertEquals(44, FibCalculator.sumEvents(100));
    }
}