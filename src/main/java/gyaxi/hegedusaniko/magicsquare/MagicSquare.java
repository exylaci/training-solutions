package gyaxi.hegedusaniko.magicsquare;

import java.util.Arrays;

public class MagicSquare {
    public boolean isMagicSquare(int[][] numbers) {
        int len = numbers.length;
        for (int[] number : numbers) {
            if (number.length != len) {
                return false;
            }
        }

        int magicNumber = Arrays.stream(numbers[0]).sum();

        int sum1;
        int sum2;
        for (int i = 0; i < len; ++i) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < len; ++j) {
                sum1 += numbers[i][j];
                sum2 += numbers[j][i];
            }
            if (sum1 != magicNumber || sum2 != magicNumber) {
                return false;
            }
        }

        sum1 = 0;
        sum2 = 0;
        for (int i = 0; i < len; ++i) {
            sum1 += numbers[i][i];
            sum2 += numbers[i][len - i - 1];
        }
        return sum1 == magicNumber && sum2 == magicNumber;
    }
}
