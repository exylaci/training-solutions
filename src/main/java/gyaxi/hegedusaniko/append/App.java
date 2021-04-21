package gyaxi.hegedusaniko.append;

import java.util.Arrays;

public class App {
    public int[] append(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}