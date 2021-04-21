package gyaxi.hegedusaniko.isunique;

import java.util.Arrays;

public class Unique {
    // rekurzióval
    public boolean isUnique(int[] numbers) {
        if (numbers.length < 2) {
            return true;
        }

        int[] temp = Arrays.copyOfRange(numbers, 1, numbers.length);

        if (Arrays.stream(temp).anyMatch(number -> number == numbers[0])) {
            return false;
        }

        return isUnique(temp);
    }

    // dupla ciklussal
//    public boolean isUnique(int[] numbers) {
//        for (int pointer = 0; pointer < numbers.length - 1; ++pointer) {
//            for (int index = pointer + 1; index < numbers.length; ++index) {
//                if (numbers[pointer] == numbers[index]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // sorbarendezéssel
//    public boolean isUnique(int[] numbers) {
//        Arrays.sort(numbers);
//
//        for (int index = 0; index < numbers.length - 1; ++index) {
//            if (numbers[index] == numbers[index + 1]) {
//                return false;
//            }
//        }
//        return true;
//    }

}
