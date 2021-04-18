package gyaxi.orokles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OfficeSoftwareTest {

    @Test
    void increasePrice() {
        Software software = new OfficeSoftware("Creator", 100);

        software.increasePrice();
        assertEquals(105, software.getPrice());
    }
}