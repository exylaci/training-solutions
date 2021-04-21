package gyaxi.hegedusaniko.lastindexof;

public class LastIndexOf {
    public int lastIndexOf(int[] numbers, int findThis) {
        int index = -1;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] == findThis) {
                index = i;
            }
        }
        return index;
    }
}