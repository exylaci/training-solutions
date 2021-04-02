package gyaxi.kovacseni.numberofdigits;

public class NumberOfDigits {
    public int getNumberOfDigits(int value) {
        int counter = 0;
        for (int i = 1; i <= value; ++i) {
            counter += Integer.toString(i).length();
        }
        return counter;
    }
}
