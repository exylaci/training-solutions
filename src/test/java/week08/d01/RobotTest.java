package week08.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RobotTest {
    @Test
    void robotTest() {
        Robot r = new Robot();

        Position p = r.move("JjBbBFfLLlL");
        assertEquals(-1, p.getX());
        assertEquals(-2, p.getY());
    }

    @Test
    void robotCorruptDirection() {
        Robot r = new Robot();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                r.move("JBFLk"));
        assertEquals("Unknown direction!", exception.getMessage());
    }
}