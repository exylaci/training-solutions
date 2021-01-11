package week11.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisorFinderTest {

    @Test
    void findDivisors() {
        DivisorFinder d = new DivisorFinder();
        assertEquals(0, d.findDivisors(0));
        assertEquals(0, d.findDivisors(29));
        assertEquals(2, d.findDivisors(15));
        assertEquals(1, d.findDivisors(425));
        assertEquals(2, d.findDivisors(120));
        assertEquals(3, d.findDivisors(122));
        assertEquals(2, d.findDivisors(4525));
        assertEquals(5, d.findDivisors(55555));
    }
}