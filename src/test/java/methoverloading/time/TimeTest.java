package methoverloading.time;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeTest {
    @Test
    public void timeTest() {
        Time t1 = new Time(1);
        Time t2 = new Time(1, 2);
        Time t3 = new Time(1, 2, 3);
        Time t4 = new Time(t3);

        assertTrue(t1.isEarlier(t2));
        assertTrue(t3.isEarlier(1, 2, 4));
        assertFalse(t3.isEarlier(1, 2, 3));
    }
}
