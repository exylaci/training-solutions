package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();

        System.out.println("What is your favorit band?");
        Scanner scanner = new Scanner(System.in);
        song.band = scanner.nextLine();

        System.out.println("What is your favorit song?");
        song.title = scanner.nextLine();

        System.out.println("How long is it?");
        song.length = scanner.nextInt();

        System.out.println(song.band + " - " + song.title + " ("+ song.length + ")" );
    }
}

