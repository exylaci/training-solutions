package week15.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BitcoinTest {

    @Test
    void findBestDatesTest() {
        Bitcoin b = new Bitcoin();

        Dates result = b.findBestDates(List.of(9, 6, 4, 1));
        assertEquals(1,result.getBuyOn());
        assertEquals(2,result.getSaleOn());

        result=b.findBestDates(List.of(190, 300, 40, 70, 200, 30, 50));
        assertEquals(2,result.getBuyOn());
        assertEquals(4,result.getSaleOn());
    }
}