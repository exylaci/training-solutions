package interfacestaticmethods;

import java.util.List;

public interface Valued {
    double getValue();

    public static double totalValue(List<Valued> values) {
        double sum = 0;
        for (Valued one : values) {
            sum += one.getValue();
        }
        return sum;
    }
}
