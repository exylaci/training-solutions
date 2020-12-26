package week08.d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlaneTest {
    @Test
    void longestWaterPartTest() {
        Plane plane = new Plane();
        assertEquals(16, plane.longestWaterPart("map.txt"));
    }

    @Test
    void longestWaterPartParameterTest() {
        Plane plane = new Plane();
        Exception exception = assertThrows(IllegalStateException.class, () ->
                plane.longestWaterPart("map..txt"));
        assertEquals("Can't read from file!", exception.getMessage());
    }
}