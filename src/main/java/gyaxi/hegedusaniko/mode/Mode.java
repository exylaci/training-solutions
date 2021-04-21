package gyaxi.hegedusaniko.mode;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Mode {
    public int mode(int[] numbers) {
        return Arrays.stream(numbers)
                .peek(number -> {
                    if (number < 0 || number > 100) {
                        throw new IllegalArgumentException("Invalid number");
                    }
                })
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new IllegalArgumentException("The array is empty!"))
                .getKey();
    }
}