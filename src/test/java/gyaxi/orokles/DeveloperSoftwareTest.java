package gyaxi.orokles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperSoftwareTest {

    @Test
    void increasePrice() {
        Software software = new DeveloperSoftware("Creator", 100);

        software.increasePrice();
        assertEquals(110, software.getPrice());
    }
}