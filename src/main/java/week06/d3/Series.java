package week06.d3;

import java.util.List;

public class Series {
    public Order calculateSeriesType(List<Integer> numbers) {
        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException("Numbers doesn't contains enough data!");
        }
        boolean incresing = true;
        boolean decreasing = true;
        for (int i = 1; i < numbers.size() && (decreasing || incresing); ++i) {
            if (numbers.get(i - 1) < numbers.get(i)) {
                decreasing = false;
            } else {                  //Külön kellene vizsgálni a numbers.get(i-1)>numbers.get(i) esetet is, ha nem lenne kikötés, hogy a bemeneti lista nem tartalmazhat egymás után egyenlő értékeket.
                incresing = false;
            }
        }
        if (incresing) {
            return Order.INCREASING;
        }
        if (decreasing) {
            return Order.DECREASING;
        }
        return Order.SCRABBLED;
    }
}
