package week05.d05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void constructorTest() {
        new User("first", "last", "@.");

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("first", "last", null));
        assertEquals("Email must contains @ and . caracters!", exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("first", "last", "@"));
        assertEquals("Email must contains @ and . caracters!", exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new User("first", "last", "."));
        assertEquals("Email must contains @ and . caracters!", exception.getMessage());
    }

    @Test
    void getFullNameTest() {
        User user = new User("first", "last", "@.");

        assertEquals("first last", user.getFullName());
    }
}
