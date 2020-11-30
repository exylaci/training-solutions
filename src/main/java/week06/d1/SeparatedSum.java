package week06.d1;

public class SeparatedSum {
    public static final String ERROR_NULL = "Input string is a must!";
    public static final String ERROR_WRONG = "Wrong format double string!";

    public Sums sum(String doubles) {
        if (doubles == null || doubles.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL);
        }

        double positiv = 0;
        double negativ = 0;
        double temp;
        for (String one : doubles.split(";")) {
            try {
                temp = Double.parseDouble(one.replace(',', '.'));
                if (temp < 0) {
                    negativ += temp;
                } else {
                    positiv += temp;
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_WRONG);
            }
        }
        return new Sums(positiv, negativ);
    }
}
