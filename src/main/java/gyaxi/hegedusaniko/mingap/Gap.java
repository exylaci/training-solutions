package gyaxi.hegedusaniko.mingap;

public class Gap {
    public long minGap(int[] numbers) {
        if (numbers.length < 2) {
            return 0;
        }

        long minDistance = Long.MAX_VALUE;
        for (int index = 0; index < numbers.length - 1; ++index) {
            minDistance = Math.min(minDistance, numbers[index + 1] - numbers[index]);
        }
        return minDistance;
    }
}
