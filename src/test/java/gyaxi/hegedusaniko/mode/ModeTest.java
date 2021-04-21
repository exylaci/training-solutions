package gyaxi.hegedusaniko.mode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModeTest {

    @Test
    void modeTest() {
        Mode m = new Mode();

        assertEquals(15, m.mode(new int[]{27, 15, 15, 11, 18}));
        assertEquals(27, m.mode(new int[]{27, 27, 27, 27}));
        assertEquals(27, m.mode(new int[]{27}));
    }

    @Test
    void modeInvalidParameterTest() throws IllegalArgumentException {
        Mode m = new Mode();

        Exception ex = assertThrows(IllegalArgumentException.class, () -> m.mode(new int[]{-1, 2, 2, 3, 4, 5}));
        assertEquals("Invalid number", ex.getMessage());
    }

    @Test
    public void modeOtherInvalidParameterTest() throws IllegalArgumentException {
        Mode m = new Mode();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> m.mode(new int[]{2, 2, 125, 3, 4, 5,}));
        assertEquals("Invalid number", ex.getMessage());
    }
}