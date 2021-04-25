package gyaxi.kovacseni.fractionreduction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FractionReduction {

    public static final int MAX_NUMBER = 144;

    //cost effective algorithm
    public int getNumberOfNotReductiveFractions() {
        List<Integer> dividers = getDividers();

        return (int) Stream
                .iterate(1, n -> n + 1)
                .limit(MAX_NUMBER)
                .filter(n -> notHasCommonDivider(n, dividers))
                .count();
    }

    private List<Integer> getDividers() {
        return Stream
                .iterate(2, n -> n + 1)
                .limit(MAX_NUMBER / 2)
                .filter(n -> MAX_NUMBER % n == 0)
                .collect(Collectors.toList());
    }

    private boolean notHasCommonDivider(Integer number, List<Integer> dividers) {
        for (int i : dividers) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

//    simple algorithm
//    public int getNumberOfNotReductiveFractions() {
//        int counter = 0;
//        for (int number = 1; number < 144; ++number) {
//            if (!canBeSimplified(number)) {
//                ++counter;
//            }
//        }
//        return counter;
//    }
//
//    private boolean canBeSimplified(int number) {
//        for (int divider = 2; divider <= number; ++divider) {
//            if (144 % divider == 0 && number % divider == 0) {
//                return true;
//            }
//        }
//        return false;
//    }
}