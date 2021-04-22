package gyaxi.orokles.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroundStaffTest {

    @Test
    void create() {
        GroundStaff groundStaff = new GroundStaff("Józsi", 33, "kerékpumpáló");

        assertEquals("Józsi", groundStaff.getName());
        assertEquals(33, groundStaff.getAge());
        assertEquals("kerékpumpáló", groundStaff.getJob());
        assertFalse(groundStaff.getType().isTravel());
    }
}