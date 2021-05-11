package gyaxi.algorithms;

public class LongestBorder {

    public static final char BLACK = '#';
    public static final char WHITE = '.';

    public int longestBorder(char[][] shape) {
        return Math.max(horizontal(shape), vertical(shape));
    }

    private int horizontal(char[][] shape) {
        int longest = 0;
        for (int y = 0; y < shape.length; ++y) {
            int above = 0;
            int under = 0;
            for (int x = 0; x < shape[y].length; ++x) {

                if (shape[y][x] == '#' && (y == 0 || shape[y - 1][x] == '.')) {
                    ++above;
                    longest = Math.max(longest, above);
                } else {
                    above = 0;
                }
                if (shape[y][x] == BLACK && (y == shape.length - 1 || shape[y + 1][x] == WHITE)) {
                    ++under;
                    longest = Math.max(longest, under);
                } else {
                    under = 0;
                }
            }
        }
        return longest;
    }

    private int vertical(char[][] shape) {
        int longest = 0;
        for (int x = 0; x < shape[0].length; ++x) {
            int left = 0;
            int right = 0;
            for (int y = 0; y < shape.length; ++y) {

                if (shape[y][x] == BLACK && (x == 0 || shape[y][x - 1] == WHITE)) {
                    ++left;
                    longest = Math.max(longest, left);
                } else {
                    left = 0;
                }
                if (shape[y][x] == '#' && (x == shape[y].length - 1 || shape[y][x + 1] == '.')) {
                    ++right;
                    longest = Math.max(longest, right);
                } else {
                    right = 0;
                }
            }
        }
        return longest;
    }
}
//You are given a table with  rows and columns. Each cell is colored with white or black. Considering the shapes created by black cells, what is the maximum border of these shapes?
//A shape is a set of connected cells. Two cells are connected if they share an edge. Note that no shape has a hole in it."
//Input:
//row = 4
//col = 13
//
//.....#####...
//......##.....
//########.....
//...#.........
//
//Output: 6