package exceptionmulticatch.converter;

public class BinaryStringConverter {
    public boolean[] binaryStringToBooleanArray(String input) {
        if (input == null) throw new NullPointerException("binaryString null");
        if (input.isBlank()) throw new IllegalArgumentException("Input is empty!");
        boolean[] result = new boolean[input.length()];
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '0') {
                result[i] = false;
            } else if (input.charAt(i) == '1') {
                result[i] = true;
            } else {
                throw new IllegalArgumentException("binaryString not valid");
            }
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] input) {
        if (input == null) throw new NullPointerException("Input is a must!");
        if (input.length == 0) throw new IllegalArgumentException("Input is empty!");
        StringBuilder result = new StringBuilder(input.length);

        for (boolean one : input) {
            result.append(one ? "1" : "0");
        }
        return result.toString();
    }
}