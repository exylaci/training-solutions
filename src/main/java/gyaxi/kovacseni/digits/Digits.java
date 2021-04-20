package gyaxi.kovacseni.digits;

import java.util.stream.Stream;

public class Digits {
    public int getNumbers() {
        return (int) Stream
                .iterate(10, n -> n + 1)
                .limit(90)
                .filter(this::isFiveTheDistance)
                .count();
    }

    private boolean isFiveTheDistance(Integer integer) {
        return integer / 10 - integer % 10 == 0 || integer % 10 - integer / 10 == 0;
    }
}