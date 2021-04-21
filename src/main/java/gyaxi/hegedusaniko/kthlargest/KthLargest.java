package gyaxi.hegedusaniko.kthlargest;

import java.util.Arrays;
import java.util.Comparator;

public class KthLargest {
    public int kthLargest(int[] numbers, int limit) {

        return Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(limit)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There is no such number!"));
    }
}