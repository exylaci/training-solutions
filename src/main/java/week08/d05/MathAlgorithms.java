package week08.d05;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {
    public static int legnagyobbKozosOsztoPrimTenyezokkel(int one, int two) {
        List<Integer> primsOfOne = getPrims(one);
        List<Integer> primsOfTwo = getPrims(two);
        List<Integer> crossSection = getCrossSection(primsOfOne, primsOfTwo);
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
        if (value == 2) return true;
        if (value == 1 || value % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(value); i += 2) {
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
        System.out.println(legnagyobbKozosOsztoPrimTenyezokkel(20, 30));
        System.out.println(legnagyobbKozosOsztoPrimTenyezokkel(504, 540));
    }
}
//A week08d05 csomagban készíts egy osztályt MathAlgorithms néven. Legyen benne egy metódus,
// greatestCommonDivisor(), ami paraméterül vár két pozitív egész számot és visszaadja a legnagyobb közös osztójukat.