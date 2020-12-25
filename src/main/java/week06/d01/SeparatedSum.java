package week06.d01;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class SeparatedSum {
    public static final String ERROR_NULL = "Input string is a must!";
    public static final String ERROR_WRONG = "Wrong format double string!";
    public static final String LIST_SEPARATOR = ";";

    public static Sums separatedSums(String doubles) {
        if (doubles == null || doubles.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL);
        }

        double positiv = 0;
        double negativ = 0;
        double temp;

        for (String one : doubles.split(LIST_SEPARATOR)) {
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
//Írj egy SeparatedSum.sum(String s) metódust, mely kap egy String-et,
// melyben lebegőpontos számok szerepelnek pontosvesszővel elválasztva.
// A számoknál vessző a tizedeselválasztó. Ezt szétszedi, és összeadja külön a pozitív és külön a negatív számokat. Mivel térnél vissza ebből a metódusból?