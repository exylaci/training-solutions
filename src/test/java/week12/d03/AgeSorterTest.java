package week12.d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeSorterTest {

    @Test
    void sortAges() {
        AgeSorter a = new AgeSorter();
        assertArrayEquals(new int[]{3,7,9,24},
                a.sortAges(new int[]{24,7,9,3}));
    }
}