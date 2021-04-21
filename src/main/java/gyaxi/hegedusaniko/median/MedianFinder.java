package gyaxi.hegedusaniko.median;

import java.util.Arrays;
import java.util.Comparator;

public class MedianFinder {
    public double median(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.naturalOrder())
                .skip((numbers.length - 1) / 2)
                .limit(2 - numbers.length % 2)
                .mapToInt(number -> number)
                .average()
                .orElse(0);
    }
}