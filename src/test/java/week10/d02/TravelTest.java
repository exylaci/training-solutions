package week10.d02;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TravelTest {

    @Test
    void getStopWithMaxTest() {
        InputStream input = getClass().getResourceAsStream("utasadat.txt");
        Travel t=new Travel();

        assertEquals(0,t.getStopWithMax(input));
    }

    @Test
    void getStopWithMaxTestParameter() {
        Travel t=new Travel();

        Exception exception = assertThrows(IllegalArgumentException.class,()->t.getStopWithMax(null));
        assertEquals("Input stream is a must!",exception.getMessage());
    }
}