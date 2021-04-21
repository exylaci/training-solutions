package gyaxi.hegedusaniko.append;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void append() {
        App a = new App();
        int[]a1 = new int[]{2,4,6};
        int[]a2 = new int[]{1,2,3,4,5};

        int[]result1 = new int[]{2,4,6,1,2,3,4,5};
        int[]result2 = new int[]{1,2,3,4,5,2,4,6};

        assertEquals(true, Arrays.equals(result1,a.append(a1, a2)));
        assertEquals(true, Arrays.equals(result2,a.append(a2, a1)));
    }
}