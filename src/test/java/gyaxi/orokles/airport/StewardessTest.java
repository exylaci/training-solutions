package gyaxi.orokles.airport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StewardessTest {

    @Test
    void createWithoutAge() {
        Stewardess stewardess = new Stewardess("Gizike", Position.TEAM_LEADER);

        assertEquals("Gizike", stewardess.getName());
        assertEquals(Position.TEAM_LEADER, stewardess.getPosition());
        assertTrue(stewardess.getType().isTravel());
    }

    @Test
    void createWithAge() {
        Stewardess stewardess = new Stewardess("Garcon", 23, Position.SUBORDINATE);

        assertEquals("Garcon", stewardess.getName());
        assertEquals(23, stewardess.getAge());
        assertEquals(Position.SUBORDINATE, stewardess.getPosition());
        assertTrue(stewardess.getType().isTravel());
    }
}