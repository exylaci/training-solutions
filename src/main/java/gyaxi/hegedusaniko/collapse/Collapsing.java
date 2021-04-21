package gyaxi.hegedusaniko.collapse;

public class Collapsing {
    public int[] collapse(int[] numbers) {
        int len = numbers.length;
        int[] result = new int[(len + 1) / 2];

        for (int index = 0; index < len / 2; ++index) {
            result[index] = numbers[index * 2] + numbers[index * 2 + 1];
        }

        if (len % 2 == 1) {
            result[len / 2] = numbers[len - 1];
        }

        return result;
    }
}