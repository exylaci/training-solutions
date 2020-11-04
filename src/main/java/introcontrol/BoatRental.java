package introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        System.out.println("Üdvözlöm önöket a csónakkölcsönzőnkben!");
        System.out.println("Kérem, írják be hányan érkeztek?");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Önöknek a következő csónakkat adjuk ki:");
        if (number>3){
            System.out.println("1db 5 személyes csónak.");
            number-=5;
        }
        if (number>=3){
            System.out.println("1db 3 személyes csónak.");
            number-=3;
        }
        if (number>0){
            System.out.println("1db 2 személyes csónak.");
            number-=2;
        }
        if (number>0){
            System.out.println("Sajnálom, de "+number+" embernek nem jutott hely a csónakokban.");
        }

    }
}
