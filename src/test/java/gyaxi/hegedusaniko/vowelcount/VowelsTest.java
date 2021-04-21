package gyaxi.hegedusaniko.vowelcount;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VowelsTest {

    @Test
    void vowelCount() {
        int[] r = new int[]{1, 3, 3, 1, 0};

        assertEquals(true, Arrays.equals(r, Vowels.vowelCount("i think, therefore i am")));
    }
}