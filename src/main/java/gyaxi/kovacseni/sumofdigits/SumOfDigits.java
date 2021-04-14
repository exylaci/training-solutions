package gyaxi.kovacseni.sumofdigits;

import java.util.Random;

public class SumOfDigits {
    public static final int ASCII_CODE_OF_ZERO = 48;

    public int getSumOfDigits(Random random) {
        int number = random.nextInt();
        return countSum(number);
    }

    private int countSum(int value) {
        value = Math.abs(value);
        if (value < 10) {
            return value;
        }

        return countSum(
                String.valueOf(value)
                        .chars()
                        .map(a -> a - ASCII_CODE_OF_ZERO)
                        .sum());
    }

//    public int getSumOfDigits(Random random) {
//        int number = random.nextInt();
//        number = Math.abs(number);
//        while (number > 9) {
//            int sum = 0;
//            while (number > 0) {
//                sum += number % 10;
//                number /= 10;
//            }
//            number = sum;
//        }
//        return number;
//    }
}