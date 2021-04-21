package gyaxi.hegedusaniko.percenteven;

import java.util.Arrays;

public class Evens {
    public double percentEven(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        long numberOfPairs = Arrays.stream(numbers)
                .filter(number -> number % 2 == 0)
                .count();

        return 100. * numberOfPairs / numbers.length;
    }
}