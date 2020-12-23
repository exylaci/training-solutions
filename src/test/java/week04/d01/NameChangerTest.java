package week04.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {
    @Test
    public void constructorTest() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Invalid name: ", ex.getMessage());
    }

    @Test
    public void changeFirstNameTest() {
        NameChanger name = new NameChanger("Gábor Áron");
        name.changeFirstName("Nagy");
        assertEquals("Nagy Áron",  name.getFullName() );
    }
}