package week12.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelTest {

    @Test
    void testToString() {
        assertEquals("(17)######", new Parcel(17, 6, "#").toString());
    }
}