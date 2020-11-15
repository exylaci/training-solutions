package algorithmssum.integers;

import java.util.List;

public class IntegerSumCalculator {
    public int sum(List<Integer> list){
        int sum = 0;
        for (int one : list){
            sum += one;
        }
        return sum;
    }
}
