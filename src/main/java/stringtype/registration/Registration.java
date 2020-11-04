package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        System.out.println("username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println(UserValidator.isValidUsername(username)?
                "A felhasználó név megfelelő.":
                "A felhasználó név rossz.");

        System.out.println("passwd:");
        String password1 = scanner.nextLine();
        System.out.println("passwd újra:");
        String password2 = scanner.nextLine();
        System.out.println(UserValidator.isValidPassword(password1,password2)?
                "A jelszó megfelelő.":
                "A jelszó nem megfelelő.");

        System.out.println("e-mail:");
        String email = scanner.nextLine();
        System.out.println(UserValidator.isValidEmail(email)?
                "Az e-mail cím helyes.":
                "Az e-mail cím rossz.");



    }
}
