package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl ic = new IntroControl();
        System.out.println("11: " + ic.substractTenIfGreaterThanTen(11));
        System.out.println("10: " + ic.substractTenIfGreaterThanTen(10));
        System.out.println();

        System.out.println("0: " + ic.describeNumber(0));
        System.out.println("1: " + ic.describeNumber(1));
        System.out.println();

        System.out.println("Joe: " + ic.greetingToJoe("Joe"));
        System.out.println("Nem Joe: " + ic.greetingToJoe("Nem Joe"));
        System.out.println();

        System.out.println(" 999999: " + ic.calculateBonus(999999));
        System.out.println("1000000: " + ic.calculateBonus(1000000));
        System.out.println();

        System.out.println(" 300 - 301 :" + ic.calculateConsumption(300,301));
        System.out.println(" 300 - 300 :" + ic.calculateConsumption(300,300));
        System.out.println(" 301 - 300 :" + ic.calculateConsumption(301,300));
        System.out.println();

        System.out.printf("-1: ");
        ic.printNumbers(-1);
        System.out.printf(" 0: ");
        ic.printNumbers(0);
        System.out.printf(" 1: ");
        ic.printNumbers(1);
        System.out.printf("10: ");
        ic.printNumbers(10);
        System.out.println();

        System.out.printf("3,8: ");
        ic.printNumbersBetween(3,8);
        System.out.printf("3,3: ");
        ic.printNumbersBetween(3,3);
        System.out.printf("8,3: ");
        ic.printNumbersBetween(8,3);
        System.out.println();

        System.out.printf("-4,4: ");
        ic.printNumbersBetweenAnyDirection(-4,4);
        System.out.printf(" 2,4: ");
        ic.printNumbersBetweenAnyDirection(2,4);
        System.out.printf(" 3,4: ");
        ic.printNumbersBetweenAnyDirection(3,4);
        System.out.printf(" 4,4: ");
        ic.printNumbersBetweenAnyDirection(4,4);
        System.out.printf(" 5,4: ");
        ic.printNumbersBetweenAnyDirection(5,4);
        System.out.printf(" 6,4: ");
        ic.printNumbersBetweenAnyDirection(6,4);
        System.out.printf("4,-4: ");
        ic.printNumbersBetweenAnyDirection(4,-4);
        System.out.println();

        System.out.printf(" 0: ");
        ic.printOddNumbers(0);
        System.out.printf(" 1: ");
        ic.printOddNumbers(1);
        System.out.printf("10: ");
        ic.printOddNumbers(10);
        System.out.println();
    }
}
