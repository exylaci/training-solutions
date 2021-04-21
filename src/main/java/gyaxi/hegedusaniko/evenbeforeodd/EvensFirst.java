package gyaxi.hegedusaniko.evenbeforeodd;

public class EvensFirst {
    int temp;

    public int[] evenBeforeOdd(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (numbers[j] % 2 == 1 || numbers[j + 1] % 2 == 0) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        return numbers;
    }
}