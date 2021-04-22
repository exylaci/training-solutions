package gyaxi.orokles.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PassengerTest {

    @Test
    void create() {
        Passenger passenger = new Passenger("Samu bácsi", 153, "15D");

        assertEquals("Samu bácsi", passenger.getName());
        assertEquals(153, passenger.getAge());
        assertEquals("15D", passenger.getSeat());
        assertTrue(passenger.getType().isTravel());
    }
}