package week09.d03;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    @Test
    void contructorTest() {
        Person person = new Person("name", 16);
        assertEquals("name", person.getName());
        assertEquals(16, person.getAge());
    }

    @Test
    void contructorConditionsTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Person("name", 0));
        assertEquals("Age must be positive!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Person(null, 16));
        assertEquals("Name cannot be empty!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Person(" ", 16));
        assertEquals("Name cannot be empty!", exception.getMessage());

    }

    @Test
    void setPresentTest() {
        Random random = new Random(4500);

        Person person = new Person("name", 14);
        person.setPresent(random);
        assertEquals(Present.TOY, person.getPresent());

        person = new Person("name", 15);
        person.setPresent(random);
        assertEquals(Present.HOUSEKEEPING, person.getPresent());
    }
}