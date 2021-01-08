package week10.d05;

import java.util.*;

public class Calculator {
    public static int MAX_NUMBER_TO_SUMMARISE = 4;

    public static void findMinSum(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("Nincs megadott adat!");

        int[] min = new int[MAX_NUMBER_TO_SUMMARISE];
        for (int i=0;i<Math.min( MAX_NUMBER_TO_SUMMARISE, arr.length);++i){
            min[i]=arr[i];
        }

        for (int indexInArr = MAX_NUMBER_TO_SUMMARISE; indexInArr < arr.length; ++indexInArr) {
            for (int indexInMin = 0; indexInMin < MAX_NUMBER_TO_SUMMARISE; ++indexInMin) {
                if (arr[indexInArr] < min[indexInMin]) {
                    min[indexInMin] = arr[indexInArr];
                    break;
                }
            }
        }

        int result = 0;
        for (int i=0; i< Math.min(MAX_NUMBER_TO_SUMMARISE,arr.length);++i) {
            result += min[i];
        }

        System.out.println(String.format("A legkisebb számok összege: %d", result));
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
        findMinSum(data);
    }

}
