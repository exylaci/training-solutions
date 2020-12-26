package week07.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {
    @Test
    void constructorTest() {
        Date date = Date.of(1999, 12, 31);

        assertEquals(1999, date.getYear());
        assertEquals(12, date.getMonth());
        assertEquals(31, date.getDay());
    }

    @Test
    void withTest() {
        Date date1 = Date.of(1999, 12, 31);

        Date date2 = date1.withYear(2000);
        assertEquals(2000, date2.getYear());
        assertEquals(12, date2.getMonth());
        assertEquals(31, date2.getDay());

        Date date3 = date1.withMonth(1);
        assertEquals(1999, date3.getYear());
        assertEquals(1, date3.getMonth());
        assertEquals(31, date3.getDay());

        Date date4 = date1.withDay(1);
        assertEquals(1999, date4.getYear());
        assertEquals(12, date4.getMonth());
        assertEquals(1, date4.getDay());
    }

    @Test
    void dateCheckTest() {

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Date.of(1999, 2, 29));
        assertEquals("Invalid date!", exception.getMessage());

        Date date = Date.of(2000, 2, 29);
        exception = assertThrows(IllegalArgumentException.class, () ->
                date.withYear(1999));
        assertEquals("Invalid date!", exception.getMessage());
    }

}
