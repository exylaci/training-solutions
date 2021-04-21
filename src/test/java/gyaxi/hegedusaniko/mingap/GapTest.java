package gyaxi.hegedusaniko.mingap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GapTest {

    @Test
    void minGapTest() {
        Gap g = new Gap();

        assertEquals(1, g.minGap(new int[]{1, 3, 6, 7, 12}));
        assertEquals(-7, g.minGap(new int[]{3, 5, 11, 4, 8}));
        assertEquals(0, g.minGap(new int[]{}));
        assertEquals(0, g.minGap(new int[]{8}));
    }
}