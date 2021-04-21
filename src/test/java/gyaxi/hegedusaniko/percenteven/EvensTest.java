package gyaxi.hegedusaniko.percenteven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvensTest {

    @Test
    public void percentEvenTest() {
        Evens e = new Evens();

        assertEquals(40.0, e.percentEven(new int[]{6, 2, 9, 11, 3}));
        assertEquals(0.0, e.percentEven(new int[]{}));
        assertEquals(0.0, e.percentEven(new int[]{9, 11, 3}));
    }
}