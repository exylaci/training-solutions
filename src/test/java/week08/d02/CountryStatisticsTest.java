package week08.d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountryStatisticsTest {
    @Test
    void countryStatisticsTest() {
        CountryStatistics cs = new CountryStatistics();
        cs.importCountries("countries.txt");

        assertEquals(11, cs.getCountries().size());
        assertEquals("Kongoi_Demokratikus_Koztarsasag", cs.maxPopulaton().getName());
    }

    @Test
    void countryStatisticsConstructorTest() {
        CountryStatistics cs = new CountryStatistics();
        Exception exception = assertThrows(IllegalStateException.class,()->
            cs.importCountries("countries..txt"));
        assertEquals("Can't read from file!", exception.getMessage());
    }
}