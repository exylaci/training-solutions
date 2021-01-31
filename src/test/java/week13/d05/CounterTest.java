package week13.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void letterCounterTest() {
        assertEquals(0, new Counter().letterCounter(null));
        assertEquals(0, new Counter().letterCounter(""));
        assertEquals(1, new Counter().letterCounter("a"));
        assertEquals(2, new Counter().letterCounter("aaba"));
        assertEquals(0, new Counter().letterCounter("1"));
        assertEquals(2, new Counter().letterCounter("a b"));
        assertEquals(4, new Counter().letterCounter("abcdABCD"));
    }
}