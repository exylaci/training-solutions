package gyaxi.hegedusaniko.range;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class RangeFinder {
    public static int range(int[] ints) {
        IntSummaryStatistics statistics = Arrays.stream(ints).summaryStatistics();
        return statistics.getMax() - statistics.getMin() + 1;
    }
}
