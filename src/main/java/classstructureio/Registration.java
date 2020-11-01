package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        System.out.println("What is your name?");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("What is your e-mail address?");
        String email = scanner.nextLine();

        System.out.println("Hi " + name + "!");
        System.out.println("You've successfully registered with the: " + email + " e-mail address.");
    }
}
