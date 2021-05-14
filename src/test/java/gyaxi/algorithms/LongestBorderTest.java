package gyaxi.algorithms;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    @Test
    void longestBorderFromFile() throws IOException {
        int[] results = new int[]{4,5,9,6,5,7,2,1,11,5};

        BufferedReader reader = Files.newBufferedReader(
                Path.of("src/test/resources/gyaxi/algorithms/LongestBorder/shapes.txt"));

        int pieces = Integer.parseInt(reader.readLine());

        for (int piece = 0; piece < pieces; ++piece) {
            String[] parts = reader.readLine().split(" ");
            int rows = Integer.parseInt(parts[0]);
            int columns = Integer.parseInt(parts[1]);

            char[][] shape = new char[rows][columns];
            for (int row = 0; row < rows; ++row) {
                String oneLine=reader.readLine();
                for(int column=0;column<columns;++column){
                    shape[row][column]=oneLine.charAt(column);
                }
            }
            assertEquals(results[piece], new LongestBorder().longestBorder(shape));
        }
    }
}