package week15.d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BitcoinTest {

    @Test
    void findBestDatesTest() {
        Bitcoin b = new Bitcoin();
        System.out.println(b.findBestDates(List.of(5, 8, 10, 3, 9, 8, 1, 6)));
        System.out.println(b.findBestDates(List.of(9, 7, 4, 1)));
    }
}