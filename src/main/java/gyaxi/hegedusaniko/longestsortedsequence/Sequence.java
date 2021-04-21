package gyaxi.hegedusaniko.longestsortedsequence;

public class Sequence {
    public int longestSortedSequence(int[] numbers) {
        int result = 0;
        int max = 1;

        for (int index = 0; index < numbers.length - 1; ++index) {
            if (numbers[index] > numbers[index + 1]) {
                max = 1;
            } else {
                ++max;
                result = Math.max(max, result);
            }
        }

        return result;
    }
}
