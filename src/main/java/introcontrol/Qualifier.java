package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        System.out.println("Írj be egy számot!");
        Scanner scanner=new Scanner(System.in);
        int number = scanner.nextInt();
        if (number<100){
            System.out.println("Kisebb mint száz.");
        } else if (number==100){
            System.out.println("Pont száz.");
        } else {
            System.out.println("Nagyobb mint száz.");
        }
    }
}
