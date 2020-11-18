package week04;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        Random rdn = new Random();
        int number = rdn.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        boolean found=false;
        do {
            System.out.printf("Your guess:" );
            try {
                guess = scanner.nextInt();
                scanner.nextLine();
            }catch (InputMismatchException e){
                System.out.println("It isn't a number!");
                guess=0;
                scanner.nextLine();
            }
            if (guess!=0){
                if ( guess<number ){
                    System.out.println("My number is bigger.");
                }else if ( guess>number ){
                    System.out.println("My number is smaller.");
                }else {
                    System.out.println("You've got it!");
                    found=true;
                }
            }
        }while (!found);
    }
}
