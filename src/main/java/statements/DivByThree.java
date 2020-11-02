package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        System.out.println("Give me a number");
        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println((number % 3 == 0 ? "This number is dividable by 3." : "This number cannot be divided by 3."));
    }
}
