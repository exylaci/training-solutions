package defaultconstructor.date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.logging.SimpleFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleDateFormatterTest {

    private SimpleDate simpleDate;

    @BeforeEach
    public void setUp() {
        simpleDate = new SimpleDate();
        simpleDate.setDate(2016, 2, 29);
    }

    @AfterEach
    public void tearDown() {
        simpleDate = null;
    }

    @Test
    public void testFormatDateStringByCountryCodeHU() {

        assertEquals("2016-2-29", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.HU, simpleDate));
    }

    @Test
    public void testFormatDateStringByCountryCodeEN() {

        assertEquals("29-2-2016", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.EN, simpleDate));
    }

    @Test
    public void testFormatDateStringByCountryCodeUS() {

        assertEquals("2-29-2016", new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.US, simpleDate));
    }

    @Test
    public void testFormatDateString() {

        assertEquals("2016-2-29", new SimpleDateFormatter().formatDateString(simpleDate));
    }

    @Test
    public void testByNullParameter() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new SimpleDateFormatter().formatDateString(null));
        assertEquals("Cannot be null!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new SimpleDateFormatter().formatDateStringByCountryCode(null, simpleDate));
        assertEquals("Cannot be null!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new SimpleDateFormatter().formatDateStringByCountryCode(CountryCode.EN, null));
        assertEquals("Cannot be null!", exception.getMessage());
    }
}