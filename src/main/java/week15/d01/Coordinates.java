package week15.d01;

import java.util.Map;

public class Coordinates {

    public Map.Entry<Double, Double> findMaximumPoint(Map<Double, Double> coordinates) {

        return coordinates
                .entrySet()
                .stream()
                .reduce(setInitialValue(),
                        (max, entry) -> max = getMax(max, entry),
                        (max, entry) -> max = getMax(max, entry));
    }

    private Map.Entry<Double, Double> getMax(Map.Entry<Double, Double> max, Map.Entry<Double, Double> entry) {
        return max.getValue() > entry.getValue() ? max : entry;
    }

    private Map.Entry<Double, Double> setInitialValue() {
        return new Map.Entry<>() {
            @Override
            public Double getKey() {
                return Double.MIN_VALUE;
            }

            @Override
            public Double getValue() {
                return Double.MIN_VALUE;
            }

            @Override
            public Double setValue(Double value) {
                return value;
            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
    }
}
//Adott egy függvénygrafikon a koordináta rendszerben. A grafikon néhány pontját megkapjuk egy Map-ben. A map kulcsa az
// x koordináta értéke pedig az y koordináta. Döntsük el, hogy a kapott pontok küzül, hol van a függvénynek maximum
// helye és ott mennyi az értéke.