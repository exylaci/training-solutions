package gyaxi.hegedusaniko.isunique;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueTest {

    @Test
    void isUnique() {
        Unique u = new Unique();

        assertEquals(true, u.isUnique(new int[]{3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97, 10, 4}));
        assertEquals(false, u.isUnique(new int[]{4, 7, 2, 3, 9, 12, -47, -19, 308, 3, 74}));
        assertEquals(true, u.isUnique(new int[]{}));
        assertEquals(true, u.isUnique(new int[]{74}));
    }
}