package week06.d3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SeriesTest {
    @Test
    public void calculateSeriesTypeArgumentTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Series().calculateSeriesType(null));
        assertEquals("Numbers doesn't contains enough data!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Series().calculateSeriesType(Arrays.asList(1)));
        assertEquals("Numbers doesn't contains enough data!", exception.getMessage());
    }

    @Test
    public void calculateSeriesTypeTest(){
        assertEquals(Order.SCRABBLED, new Series().calculateSeriesType(Arrays.asList(1,2,1)));
        assertEquals(Order.INCREASING, new Series().calculateSeriesType(Arrays.asList(1,2,3,4,5)));
        assertEquals(Order.DECREASING, new Series().calculateSeriesType(Arrays.asList(5,4,3,2,1)));
    }
}
