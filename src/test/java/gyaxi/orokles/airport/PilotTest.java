package gyaxi.orokles.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PilotTest {

    @Test
    void create() {
        Pilot pilot = new Pilot("Cook kapitány", 53, Position.CAPTAIN);

        assertEquals("Cook kapitány", pilot.getName());
        assertEquals(53, pilot.getAge());
        assertEquals(Position.CAPTAIN, pilot.getPosition());
        assertTrue(pilot.getType().isTravel());
    }
}