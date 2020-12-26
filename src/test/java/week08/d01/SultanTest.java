package week08.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SultanTest {

    @Test
    void sultanTest() {
        Sultan s = new Sultan();
        assertEquals(100, s.openDoors().length);

        for (int i = 0; i < 100; ++i) {
            if (Math.sqrt(i + 1) == Math.round(Math.sqrt(i + 1))) {
                assertEquals(Door.OPEN, s.getDoorState(i));
            } else {
                assertEquals(Door.CLOSE, s.getDoorState(i));
            }
        }
    }
}