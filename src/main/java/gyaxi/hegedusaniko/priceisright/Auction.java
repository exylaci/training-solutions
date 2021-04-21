package gyaxi.hegedusaniko.priceisright;

import java.util.Arrays;

public class Auction {
    public int priceIsRight(int[] numbers, int limit) {
        return Arrays.stream(numbers)
                .filter(number->number<limit)
                .max()
                .orElse(-1);
    }
}
