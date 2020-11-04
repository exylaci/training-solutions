package introcontrol;

import java.util.Arrays;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        double[] numbers = new double[5];
        Scanner scanner = new Scanner(System.in);
        for (int i=1 ; i<= 5 ; ++i ){
            System.out.println("Kérem a(z) " + i + ". számot:");
            numbers[i-1]=scanner.nextDouble();
            scanner.nextLine();
        }

        // double sum=0;
        // for (double number : numbers) {
        //     sum+=number;
        // }
        // System.out.println("Az összegük: " + sum);

        System.out.println("Az összegük: " + Arrays.stream(numbers).sum());  // :)
    }
}
