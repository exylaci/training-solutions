package week10.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HikingFileTest {

    @Test
    void getPlusElevationTest() {
        HikingFile hikingFile = new HikingFile();
        Elevations elevations = hikingFile.getPlusElevation(HikingFile.class.getResourceAsStream("coordinates.csv"));

        assertEquals(80, elevations.getUp());
        assertEquals(30, elevations.getDown());
    }

    @Test
    void getPlusElevationParameterTest() {
        HikingFile hikingFile = new HikingFile();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                hikingFile.getPlusElevation(HikingFile.class.getResourceAsStream("/coordinates.csv")));

        assertEquals("Can't read the coordinates!", exception.getMessage());
    }

    @Test
    void getPlusElevationInvalidFileTest1() {
        HikingFile hikingFile = new HikingFile();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                hikingFile.getPlusElevation(HikingFile.class.getResourceAsStream("coordinates_invalid_notnumber.csv")));

        assertEquals("Invalid data file, contains text instead of number!", exception.getMessage());
    }

    @Test
    void getPlusElevationInvalidFileTest2() {
        HikingFile hikingFile = new HikingFile();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                hikingFile.getPlusElevation(HikingFile.class.getResourceAsStream("coordinates_invalid_missing_altitude.csv")));

        assertEquals("Invalid data file, missing the altitude data!", exception.getMessage());
    }
}