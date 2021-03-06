package introcontrol;

import java.util.Arrays;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {

        // A verzió (tömbbel)
        double[] numbers = new double[5];
        Scanner scanner = new Scanner(System.in);
        for (int i=1 ; i<= 5 ; ++i ){
            System.out.println("Kérem a(z) " + i + ". számot:");
            numbers[i-1]=scanner.nextDouble();
            scanner.nextLine();
        }
        // A.1. verzió (for each ciklussal)
        double sum=0;
        for (double number : numbers) {
            sum+=number;
        }
        System.out.println("Az összegük: " + sum);

        // A.2 verzió (beépített metódussal)
        System.out.println("Az összegük: " + Arrays.stream(numbers).sum());  // :)



        // B verzió (minden nélkül 1 ciklussal)
        double total=0;
        for (int i=1 ; i<= 5 ; ++i ) {
            System.out.println("Kérem a(z) " + i + ". számot:");
            total += scanner.nextDouble();
            scanner.nextLine();
        }
        System.out.println("Az összegük: " + total);
    }
}
