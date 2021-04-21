package gyaxi.hegedusaniko.countinrange;

import java.util.Arrays;

public class CountInRange {
    public int countInRange(int[] range, int min, int max) {
        return (int) Arrays.stream(range)
                .filter(item -> item > min)
                .filter(item -> item < max)
                .count();
    }
}