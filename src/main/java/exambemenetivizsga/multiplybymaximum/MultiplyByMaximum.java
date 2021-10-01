package exambemenetivizsga.multiplybymaximum;

public class MultiplyByMaximum {
    public int[] multiplyByMaximum(int[] numbers, int frequently) {
        checkInputs(numbers, frequently);

        int[] result = new int[numbers.length];
        int max = findMax(numbers);

        for (int index = 0; index < numbers.length; ++index) {
            if ((index + 1) % frequently == 0) {
                result[index] = numbers[index] * max;
            } else {
                result[index] = numbers[index];
            }
        }

        return result;
    }

    private void checkInputs(int[] numbers, int frequently) {
        if (frequently < 1) {
            throw new IllegalArgumentException("Invalid data for frequently!");
        }
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers is a must!");
        }
    }

    private int findMax(int[] numbers) {
        int max = 0;
        for (int oneNumber : numbers) {
            if (oneNumber > max) {
                max = oneNumber;
            }
        }
        return max;
    }
}