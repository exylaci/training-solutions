package week08.d02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CountryStatisticsTest {
    @Test
    void countryStatisticsTest() {
        CountryStatistics cs = new CountryStatistics();
        cs.importCountries("countries.txt");
        assertEquals(11, cs.getCountries().size());

    }

    @Test
    void countryStatisticsConstructorTest() {
        CountryStatistics cs = new CountryStatistics();
        Exception exception = assertThrows(IllegalStateException.class, () ->
                cs.importCountries("/countries.txt"));
        assertEquals("Can't read from file!", exception.getMessage());
    }

    @Test
    void countryStatisticsListModificationTest() {
        CountryStatistics cs = new CountryStatistics();
        Exception exception = assertThrows(UnsupportedOperationException.class, () ->
                cs.getCountries().add(new Country("test", 1, 1, 1)));
        assertEquals(0, cs.getCountries().size());
    }

    @Test
    void countryStatisticsCountryModificationTest() {
        CountryStatistics cs = new CountryStatistics();
        cs.importCountries("countries.txt");

        Exception exception = assertThrows(UnsupportedOperationException.class, () ->
                cs.getCountries().set(0, new Country("temp", 1, 1, 1)));
        assertFalse("temp".equals(cs.getCountries().get(0).getName()));
    }
}
