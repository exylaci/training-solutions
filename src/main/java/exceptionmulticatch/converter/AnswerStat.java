package exceptionmulticatch.converter;

public class AnswerStat {
    BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert(String input) {
        boolean[] result = null;
        try {
            result = binaryStringConverter.binaryStringToBooleanArray(input);
        } catch (NullPointerException | IllegalArgumentException exception) {
            throw new InvalidBinaryStringException(exception);
        }
        return result;
    }

    public int answerTruePercent(String input) {
        boolean[] data = null;
        try {
            data = binaryStringConverter.binaryStringToBooleanArray(input);
        } catch (NullPointerException | IllegalArgumentException exception) {
            throw new InvalidBinaryStringException(exception);
        }
        int counter = 0;
        for (boolean one : data) {
            if (one) ++counter;
        }
        return (int) Math.round(counter * 100. / data.length);
    }
}