package week10.d05;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator2 {
    public static final int MAX_NUMBER_FOR_SUMM = 4;

    public static void findMinMaxSum(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Nem kaptam adatot!");

        Arrays.sort(arr);

        int min = 0;
        int max = 0;
        for (int i = 0; i < MAX_NUMBER_FOR_SUMM && i < arr.length; ++i) {
            min += arr[i];
            max += arr[arr.length - 1 - i];
        }

        System.out.printf("A legkissebbek összege: %d%nA legnagyobbak összege: %d", min, max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String s = scanner.nextLine();
        while (!s.isBlank()) {
            try {
                numbers.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Számot írj!");
            }
            s = scanner.nextLine();
        }
        int[] data = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); ++i) {
            data[i] = numbers.get(i);
        }
        findMinMaxSum(data);
    }
}
