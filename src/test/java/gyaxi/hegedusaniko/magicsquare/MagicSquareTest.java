package gyaxi.hegedusaniko.magicsquare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagicSquareTest {

    @Test
    void isMagicSquare() {
        int[][] validMatrix2 = {{2, 2}, {2, 2}};
        int[][] validMatrix3 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        int[][] invalidMatrix1 = {{1}, {1}};
        int[][] invalidMatrix2 = {{2, 2, 2}, {2, 2, 2}};
        int[][] invalidMatrix3 = {{2, 6, 7}, {9, 1, 5}, {4, 8, 3}};

        assertTrue(new MagicSquare().isMagicSquare(validMatrix2));
        assertTrue(new MagicSquare().isMagicSquare(validMatrix3));
        assertFalse(new MagicSquare().isMagicSquare(invalidMatrix1));
        assertFalse(new MagicSquare().isMagicSquare(invalidMatrix2));
        assertFalse(new MagicSquare().isMagicSquare(invalidMatrix3));
    }
}