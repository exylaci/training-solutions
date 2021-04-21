package gyaxi.hegedusaniko.standarddev;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class Deviation {
    public double standardDeviation(double[] numbers) {
        DoubleSummaryStatistics statistics = Arrays.stream(numbers).summaryStatistics();

        double sumOfAverages = Arrays.stream(numbers)
                .map(number -> Math.pow((number - statistics.getAverage()), 2))
                .sum();

        return Math.sqrt(sumOfAverages / (numbers.length - 1));
    }
}