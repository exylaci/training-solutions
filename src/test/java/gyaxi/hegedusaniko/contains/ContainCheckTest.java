package gyaxi.hegedusaniko.contains;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainCheckTest {

    @Test
    void containsTest() {
        int[] a1 = new int[]{1, 6, 2, 1, 4, 1, 2, 1, 8};
        int[] a2 = new int[]{1, 2, 1};
        int[] a3 = new int[]{2, 1, 2};
        int[] a4 = new int[]{2, 1, 2};

        assertEquals(true, ContainCheck.contains(a1, a2));
        assertEquals(false, ContainCheck.contains(a2, a1));
        assertEquals(false, ContainCheck.contains(a1, a3));
        assertEquals(true, ContainCheck.contains(a3, a4));
    }
}