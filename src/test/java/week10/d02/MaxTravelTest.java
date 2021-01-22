package week10.d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxTravelTest {

    @Test
    void getMaxIndexTest() {
        assertEquals(12, new MaxTravel().getMaxIndex(List.of(17, 12, 1, 12, 6, 12, 0, 29, 17, 17, 3, 4, 4)));
    }

    @Test
    void getMaxIndexTestParameter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new MaxTravel().getMaxIndex(null));
        assertEquals("The passengers list is a must!", exception.getMessage());
    }
}