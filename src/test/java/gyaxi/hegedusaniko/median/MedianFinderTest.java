package gyaxi.hegedusaniko.median;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void medianEvenTest() {
        MedianFinder mf = new MedianFinder();

        assertEquals(30, mf.median(new int[]{10, 20, 30, 40, 50}));
        assertEquals(5, mf.median(new int[]{5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17}));
        assertEquals(25, mf.median(new int[]{42, 37, 1, 97, 1, 2, 7, 42, 3, 25, 89, 15, 10, 29, 27}));
    }

    @Test
    void medianEOddTest() {
        MedianFinder mf = new MedianFinder();

        assertEquals(25, mf.median(new int[]{10, 20, 30, 40}));
        assertEquals(2.5, mf.median(new int[]{1, 4, 2, 4, 2, 3, 5, 3, 1, 1}));
    }
}