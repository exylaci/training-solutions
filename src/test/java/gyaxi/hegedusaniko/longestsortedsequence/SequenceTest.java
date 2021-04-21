package gyaxi.hegedusaniko.longestsortedsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequenceTest {

    @Test
    void longestSortedSequence() {
        Sequence s = new Sequence();

        assertEquals(4, s.longestSortedSequence(new int[]{3, 8, 10, 1, 9, 14, -3, 0, 14, 207, 56, 98, 12}));
        assertEquals(5, s.longestSortedSequence(new int[]{17, 42, 3, 5, 5, 5, 8, 2, 4, 6, 1, 19}));
        assertEquals(0, s.longestSortedSequence(new int[]{}));
    }
}