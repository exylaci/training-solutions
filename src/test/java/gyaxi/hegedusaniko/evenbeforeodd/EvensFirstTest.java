package gyaxi.hegedusaniko.evenbeforeodd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EvensFirstTest {

    @Test
    void evenBeforeOdd() {
        EvensFirst e = new EvensFirst();

        int[] result = e.evenBeforeOdd(new int[]{5, 4, 3, 11, 9, 10, 4, 7, 2});

        assertEquals(true, result[3] % 2 == 0);
        assertEquals(true, result[2] % 2 == 0);
        assertEquals(true, result[1] % 2 == 0);
        assertEquals(true, result[0] % 2 == 0);
    }
}