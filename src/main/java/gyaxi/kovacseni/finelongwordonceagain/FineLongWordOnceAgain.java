package gyaxi.kovacseni.finelongwordonceagain;

public class FineLongWordOnceAgain {
    public char[][] getFineLongWordOnceAgainButNowInAReverseWay(String text, int len) {
        if (text.length() < len) {
            throw new IllegalArgumentException("Number of letters cannot be more than length of the word!");
        }

        char[][] result = new char[text.length() - len + 1][len];
        String uppercased = text.toUpperCase();

        for (int index = 0; index < result.length; ++index) {
            result[index] = uppercased.substring(index, len + index).toCharArray();
        }

        return result;
    }
}