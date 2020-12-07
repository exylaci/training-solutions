package week07.d1;

public class MathAlgoritmus {


    static boolean isPrim(long number) {
        if (number < 1) {
            throw new IllegalArgumentException("Pozitív egész szám kell!");
        }

        long numberOfDividers = 0;
        for (long i = 1; i <= number; ++i) {
            if (number % i == 0) {
                ++numberOfDividers;
            }
        }
        if (numberOfDividers == 2) {
            return true;
        }
        return false;
    }
}
