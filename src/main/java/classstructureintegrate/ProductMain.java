package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        System.out.println("What is the product?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("What does it costs?");
        int price = scanner.nextInt();

        Product product = new Product(name,price);
        product.increasePrice(50);
        System.out.println("New price: "+product.getPrice());
        product.decreasePrice(100);
        System.out.println("New price: "+product.getPrice());
    }
}
