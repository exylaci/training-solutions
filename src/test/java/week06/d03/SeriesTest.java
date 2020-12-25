package week06.d03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

public class SeriesTest {
    @Test
    public void calculateSeriesTypeTest() {
        assertEquals(Order.SCRABBLED, Series.calculateSeriesType(Arrays.asList(1, 2, 1)));
        assertEquals(Order.INCREASING, Series.calculateSeriesType(Arrays.asList(1, 2, 3, 4, 5)));
        assertEquals(Order.DECREASING, Series.calculateSeriesType(Arrays.asList(5, 4, 3, 2, 1)));
    }

    @Test
    public void calculateSeriesTypeArgumentTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Series.calculateSeriesType(null));
        assertEquals("Numbers doesn't contains enough data!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                Series.calculateSeriesType(Arrays.asList(1)));
        assertEquals("Numbers doesn't contains enough data!", exception.getMessage());
    }
}