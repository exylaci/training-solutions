package week02;

import java.util.Scanner;

public class Product {
    String name;
    String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public boolean areTheyEqual(Product p){
        return this.name.equals(p.name) && Math.abs( this.code.length()-p.code.length())<2
                ? true : false;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static void main(String[] args) {
        System.out.println("Első neve:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Első kódja:");
        String code = scanner.nextLine();
        Product p1 = new Product(name,code);

        System.out.println("Második neve:");
        name = scanner.nextLine();
        System.out.println("Második kódja:");
        code = scanner.nextLine();
        Product p2 = new Product(name,code);

        System.out.println("1: "+p1.name + " "+p1.code);
        System.out.println("2: "+p2.name + " "+p2.code);

        System.out.println(p1.areTheyEqual(p2)?
                "Egyenlők":
                "Nem egyenlők");
    }
}
