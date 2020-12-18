package week08.d05;

public class MathAlgorithms {
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
}
