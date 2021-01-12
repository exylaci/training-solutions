package week11.d02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {
    static Courier courier = new Courier();

    @BeforeAll
    static void beforeAll() {
        courier.loadTransports("rides.txt");
    }

    @Test
    void loadTransports() {
        Courier courier = new Courier();
        courier.loadTransports("rides.txt");
        assertEquals(61, courier.getRideList().size());
        assertEquals(1, courier.getRideList().get(5).getDay());
        assertEquals(4, courier.getRideList().get(5).getTransport());
        assertEquals(9, courier.getRideList().get(5).getDistance());
    }

    @Test
    void findFirstTransport() {
        assertEquals(1, courier.findFirstTransport().getDay());
        assertEquals(1, courier.findFirstTransport().getTransport());
        assertEquals(3, courier.findFirstTransport().getDistance());
    }

    @Test
    void dayOffs() {
        assertEquals(2, courier.dayOffs().size());
        assertEquals(2, courier.dayOffs().get(0));
        assertEquals(6, courier.dayOffs().get(1));
    }

    @Test
    void getDailyDistances() {
        assertEquals(65, courier.getDailyDistances().get(1));
        assertEquals(0, courier.getDailyDistances().get(2));
        assertEquals(69, courier.getDailyDistances().get(3));
        assertEquals(62, courier.getDailyDistances().get(4));
        assertEquals(74, courier.getDailyDistances().get(5));
        assertEquals(0, courier.getDailyDistances().get(6));
        assertEquals(75, courier.getDailyDistances().get(7));
    }
}