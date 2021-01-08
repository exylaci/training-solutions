package week10.d05;

import java.util.*;

public class Calculator {
    public static int MAX_NUMBER_TO_SUMMARISE = 4;

    public MinMax findMinMaxSum(int[] input) {
        if (input == null) return new MinMax();

        List<Integer> numbers = new ArrayList<>();
        for (Integer one : input) {
            numbers.add(one);
        }

        MinMax result = new MinMax();
        Collections.sort(numbers);
        for (int i = 0; i < MAX_NUMBER_TO_SUMMARISE && i < numbers.size(); ++i) {
            result.incrementMin(numbers.get(i));
            result.incrementMax(numbers.get(numbers.size() - i - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> inputNumbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                inputNumbers.add(scanner.nextInt());
            } catch (InputMismatchException e) {
                break;
            }
        } while (true);


        System.out.println(inputNumbers);
        int[] numbers = new int[inputNumbers.size()];
        for(int i = 0; i<inputNumbers.size();++i){
            numbers[i]=inputNumbers.get(i);
        }

        Calculator c = new Calculator();
        MinMax result = c.findMinMaxSum(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println(result.min);
        System.out.println(result.max);

    }
}
