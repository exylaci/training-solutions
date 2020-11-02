package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me the first time:");

        System.out.println("hours:");
        int hours = scanner.nextInt();
        scanner.nextLine();

        System.out.println("minutes:");
        int minutes = scanner.nextInt();
        scanner.nextLine();

        System.out.println("seconds:");
        int seconds = scanner.nextInt();
        scanner.nextLine();

        Time timeOne = new Time(hours,minutes,seconds);

        System.out.println("Give me the second time:");

        System.out.println("hours:");
        hours = scanner.nextInt();
        scanner.nextLine();

        System.out.println("minutes:");
        minutes = scanner.nextInt();
        scanner.nextLine();

        System.out.println("seconds:");
        seconds = scanner.nextInt();
        scanner.nextLine();

        Time timeTwo = new Time(hours,minutes,seconds);

        System.out.println("The first time is " + timeOne.toString() + " = " +
                timeOne.getInMinutes() + " minutes.");
        System.out.println("The second time is " + timeTwo.toString() + " = " +
                timeTwo.getInSeconds() + " seconds.");
        System.out.println("The first time is earlier than the second one: " + timeOne.earlier(timeTwo));

    }
}
