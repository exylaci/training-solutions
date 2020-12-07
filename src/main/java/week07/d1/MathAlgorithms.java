package week07.d1;

public class MathAlgorithms {

    public boolean isPrim(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Csak pozitív egész szám!");
        }
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0 || value==1 ) {
            return false;
        }
        int limit = (int) Math.sqrt(value) + 1;
        for (int i = 3; i < limit; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}