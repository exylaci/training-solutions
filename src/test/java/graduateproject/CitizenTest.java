package graduateproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {

    @Test
    void Constructor() {
        Citizen citizen = new Citizen("Jane Doe;2091;40;jane.doe@example.com;123456789");

        assertEquals("Jane Doe", citizen.getName());
        assertEquals("2091", citizen.getZip());
        assertEquals(40, citizen.getAge());
        assertEquals("jane.doe@example.com", citizen.getEmail());
        assertEquals("123456789", citizen.getTaj());
    }

    @Test
    void ConstructorInvalidData() {
        Citizen citizen = new Citizen("name;zip;0;email;taj");

        assertThrows(IllegalArgumentException.class, () -> new Citizen("name;zip;age;email;taj"));
        assertThrows(IllegalArgumentException.class, () -> new Citizen("name;zip;0;email"));
        assertThrows(IllegalArgumentException.class, () -> new Citizen("name;zip;0;email;taj;more"));
    }
}