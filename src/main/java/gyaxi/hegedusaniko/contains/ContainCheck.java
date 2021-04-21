package gyaxi.hegedusaniko.contains;

import java.util.Arrays;

public class ContainCheck {
    public static boolean contains(int[] numbers, int[] parts) {
        for (int index = 0; index < numbers.length - parts.length + 1; ++index) {

            if (Arrays.equals(
                    Arrays.copyOfRange(numbers, index, index + parts.length),
                    parts)) {
                return true;
            }

        }
        return false;
    }
}