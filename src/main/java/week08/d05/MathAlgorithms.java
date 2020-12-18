package week08.d05;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {
    public static int legnagyobbKozosOsztoPrimTenyezokkel(int one, int two) {
        List<Integer> ones = getPrims(one);
        List<Integer> twos = getPrims(two);
        List<Integer> crossSection = getCrossSection(ones, twos);
        int result = multiply(crossSection);
        return result;
    }


    public static int greatestCommonDivisor(int one, int two) {
        if (one < 1 || two < 1) throw new IllegalArgumentException("Only positive numbers are accepted!");
        while (one != two) {
            if (one > two) {
                one -= two;
            } else {
                two -= one;
            }
        }
        return one;
    }

    private static List<Integer> getPrims(int value) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= value; ++i) {
            if (isPrim(i)) {
                while (value % i == 0) {
                    result.add(i);
                    value /= i;
                }
            }
        }
        return result;
    }

    private static boolean isPrim(int value) {
        for (int i = 2; i <= Math.sqrt(value); ++i) {
            if (value % i == 0) return false;
        }
        return true;
    }

    private static List<Integer> getCrossSection(List<Integer> ones, List<Integer> twos) {
        List<Integer> result = new ArrayList<>();
        for (Integer one : ones) {
            for (int i = 0; i < twos.size(); ++i) {
                if (one == twos.get(i)) {
                    result.add(one);
                    twos.remove(i);
                    break;
                }
            }
        }
        return result;
    }

    private static int multiply(List<Integer> values) {
        int result = 1;
        for (Integer one : values) {
            result *= one;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(legnagyobbKozosOsztoPrimTenyezokkel(20,30));
        System.out.println(legnagyobbKozosOsztoPrimTenyezokkel(504,540));
    }
}
