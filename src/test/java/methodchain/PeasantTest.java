package methodchain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeasantTest {
    @Test
    public void peasantTest() {

        assertEquals("X: 4, Y: 2",
                new Peasant(2, 3)
                        .forward()
                        .forward()
                        .left()
                        .back()
                        .left()
                        .forward()
                        .right()
                        .toString());
    }
}
