package exambemenetivizsga.multiplybymaximum;

public class MultiplyByMaximum {
    public int[] multiplyByMaximum(int[] numbers, int n) {
        checkInputs(numbers, n);

        int[] result = new int[numbers.length];
        int max = findMax(numbers);

        for (int i = 0; i < numbers.length; ++i) {
            if ((i + 1) % n == 0) {
                result[i] = numbers[i] * max;
            } else {
                result[i] = numbers[i];
            }
        }

        return result;
    }

    private void checkInputs(int[] numbers, int n) {
        if (numbers == null || n < 1) {
            throw new IllegalArgumentException();
        }
    }

    private int findMax(int[] numbers) {
        int max = 0;
        for (int one : numbers) {
            if (one > max) {
                max = one;
            }
        }
        return max;
    }
}