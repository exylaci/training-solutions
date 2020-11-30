package week06.d1;

import java.text.NumberFormat;
import java.util.IllformedLocaleException;
import java.util.Locale;

public class SeparatedSum {
    public static final String ERROR_NULL = "Input string is a must!";

    public Sums sum(String doubles) {
        if (doubles == null || doubles.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL);
        }

        double positiv = 0;
        double negativ = 0;
        for (String one : doubles.split(";")) {
            double temp = Double.parseDouble(one.replace(',', '.'));
            if (temp < 0) {
                negativ += temp;
            } else {
                positiv += temp;
            }
        }
        return new Sums(positiv, negativ);
    }
}
