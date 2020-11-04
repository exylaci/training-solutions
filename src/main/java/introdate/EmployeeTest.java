package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("Munkavállaló neve:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("születési év:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" hónap:");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" nap:");
        int day = scanner.nextInt();
        scanner.nextLine();
        Employee employee = new Employee(year,month,day,name);

        System.out.println(employee.getName());
        System.out.println("Született: " + employee.getDateOfBirth());
        System.out.println("Belépett: " + employee.getBeginEmployment());
    }
}
