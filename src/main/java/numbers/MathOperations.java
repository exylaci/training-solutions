package numbers;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        System.out.print("3 * ( 2 + 3 - (1/3) ) = ");
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                Math.abs(3*(2+3-(1./3))-scanner.nextDouble())<=0.0001 ?
                "A válasz helyes." :
                "Rossz válasz!");
    }
}
