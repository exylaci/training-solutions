package gyaxi.hegedusaniko.lastindexof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LastIndexOfTest {

    @Test
    void lastIndexOfTest() {
        LastIndexOf l = new LastIndexOf();
        int[] numbers = new int[]{74, 85, 102, 99, 101, 85, 56};

        assertEquals(5, l.lastIndexOf(numbers, 85));
    }

    @Test
    void valueNotFoundTest() {
        LastIndexOf l = new LastIndexOf();
        int[] numbers = new int[]{74, 85, 102, 99, 101, 85, 56};

        assertEquals(-1, l.lastIndexOf(numbers, 100));
    }
}