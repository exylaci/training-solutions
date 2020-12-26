package week09.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SantaClausTest {
    SantaClaus sc = new SantaClaus(List.of(
            new Person("child 1", 1),
            new Person("child 15", 5),
            new Person("child 19", 9),
            new Person("child 14", 14),
            new Person("adult 15", 21),
            new Person("adult 18", 21),
            new Person("adult 21", 21),
            new Person("adult 100", 21)));

    @Test
    void constructorTest() {
        assertEquals(8, sc.getPeople().size());
    }

    @Test
    void getThroughChimneysTest() {
        sc.getThroughChimneys(4500);

        assertEquals(Present.TOY, sc.getPeople().get(0).getPresent());
        assertEquals(Present.ELECTRONIC, sc.getPeople().get(1).getPresent());
        assertEquals(Present.HOUSEKEEPING, sc.getPeople().get(2).getPresent());
        assertEquals(Present.TOY, sc.getPeople().get(3).getPresent());
        assertEquals(Present.HOUSEKEEPING, sc.getPeople().get(4).getPresent());
        assertEquals(Present.HOUSEKEEPING, sc.getPeople().get(6).getPresent());
        assertEquals(Present.ELECTRONIC, sc.getPeople().get(7).getPresent());
    }

    @Test
    void constructorErrorTest() {
        Exception exception = assertThrows(IllegalArgumentException.class,()->
            new SantaClaus(null));
        assertEquals("List cannot be empty!", exception.getMessage());
    }
}