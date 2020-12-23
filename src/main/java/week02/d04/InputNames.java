package week02.d04;

import java.util.Scanner;

public class InputNames {
    public static void main(String[] args) {
        String[] names = new String[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; ++i) {
            System.out.println("Kérem a(z) " + (i + 1) + ". nevet:");
            names[i] = scanner.nextLine();
        }
        for (int i = 0; i < 5; ++i) {
            System.out.println((i + 1) + ". név: " + names[i]);
        }
    }
}
//Hozz létre egy InputNames Java osztályt, melynek van egy main metódusa.
// Ciklusban kérj be öt nevet!
// A neveket tárold el egy tömbben!
// Írd ki a tömb tartalmát, sortöréssel elválasztva (írd bele, hogy hanyadik elem - 1-től sorszámozva)!