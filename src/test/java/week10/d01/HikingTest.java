package week10.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevationTest() {
        List<Double> levels = List.of(3.5, 13.5, 20., 18., 19.);
        Hiking hiking = new Hiking();

        assertEquals(17.5, hiking.getPlusElevation(levels));
    }

    @Test
    void getPlusElevationBoundaryConditionTest() {
        List<Double> levels = List.of(3.5);
        Hiking hiking = new Hiking();

        assertEquals(0, hiking.getPlusElevation(levels));
    }

    @Test
    void getPlusElevationParameterTest() {
        Hiking hiking = new Hiking();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                hiking.getPlusElevation(null));
        assertEquals("Levels list is a must!", exception.getMessage());
    }
}