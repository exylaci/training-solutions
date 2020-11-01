package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();

        System.out.println("What is the name of the client?");
        Scanner scanner = new Scanner(System.in);
        client.name= scanner.nextLine();

        System.out.println("When the client was born?");
        client.year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is the address of the client?");
        client.address = scanner.nextLine();

        System.out.println("Client name:" + client.name);
        System.out.println("Client birth date:" + client.year);
        System.out.println("Client address:" + client.address);
    }
}
