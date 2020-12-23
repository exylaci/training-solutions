package week05.d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

    @Test
    void listCounterTest() {
        assertEquals(0, new ListCounter().listCounter(null));
        assertEquals(0, new ListCounter().listCounter(Arrays.asList()));
        assertEquals(2, new ListCounter().listCounter(Arrays.asList("Ali", null, "Baba", "", "egy", "angyal")));
    }

    @Test
    void listMergerTest() {
        assertEquals("0", new ListCounter().listMerger(null));
        assertEquals("0", new ListCounter().listMerger(Arrays.asList()));
        assertEquals("Aliangyal", new ListCounter().listMerger(Arrays.asList("Ali", null, "Baba", "", "egy", "angyal")));
    }
}