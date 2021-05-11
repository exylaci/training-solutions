package gyaxi.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestBorderTest {

    @Test
    void longestBorderHorizontal() {
        char[][] shape = new char[][]{
                {'.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'#', '#', '#', '#', '#', '#', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        assertEquals(6, new LongestBorder().longestBorder(shape));
    }

    @Test
    void longestBorderVertical() {
        char[][] shape = new char[][]{
                {'.', '#', '#', '#'},
                {'.', '.', '#', '#'},
                {'#', '#', '#', '#'},
                {'#', '#', '#', '#'},
                {'.', '.', '.', '#'}};

        assertEquals(5, new LongestBorder().longestBorder(shape));
    }

    @Test
    void longestBorderEmpty() {
        char[][] shape = new char[][]{{'.'}};

        assertEquals(0, new LongestBorder().longestBorder(shape));
    }

    @Test
    void longestBorderFull() {
        char[][] shape = new char[][]{{'#'}};

        assertEquals(1, new LongestBorder().longestBorder(shape));
    }
}