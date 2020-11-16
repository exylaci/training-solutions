package week04;

import org.junit.jupiter.api.Test;
import pets.GENDER;
import pets.Pet;
import pets.Vet;
import stringscanner.StringScanner;

import java.time.LocalDate;

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

        assertEquals("Nagy Áron",  new NameChanger("Gábor Áron").changeFirstName("Nagy"));
    }

}
