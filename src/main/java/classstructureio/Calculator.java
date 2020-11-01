package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Please give the first integer number!");
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();

        System.out.println("Please give the second integer number!");
        int number2 = scanner.nextInt();

        System.out.println(number1 + " + " + number2);
        System.out.println("= " + (number1 + number2));

    }
}
