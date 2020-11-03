package week02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem ;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        System.out.println("Add meg az 1. phone adatait!");
        System.out.println("type:");
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        System.out.println("mem:");
        int mem = scanner.nextInt();
        scanner.nextLine();

        Phone phone1 = new Phone(type,mem);

        System.out.println("Add meg az 2. phone adatait!");
        System.out.println("type:");
        type = scanner.nextLine();
        System.out.println("mem:");
        mem = scanner.nextInt();
        scanner.nextLine();

        Phone phone2 = new Phone(type,mem);


    }
}
