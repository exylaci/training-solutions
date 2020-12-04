package week06.d5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {
    @Test
    public void bottleTest() {
        assertEquals(3, Bottle.of(BottleType.PET_BOTTLE).fill(3));
    }

    @Test
    void overFillTest() {
        Exception exception = assertThrows(RuntimeException.class, () ->
                Bottle.of(BottleType.PET_BOTTLE).fill(1000));
        assertEquals("The bottle would be overfilled!", exception.getMessage());
    }
}
