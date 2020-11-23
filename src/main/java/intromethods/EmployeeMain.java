package intromethods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class EmployeeMain {
    public static void main(String[] args) {

    Employee employee = new Employee(
            "Gábor Áron",
            LocalDate.of(1849, Month.AUGUST,13),
            1);
    System.out.println(employee);

    employee.raiseSalary(1000);
    System.out.println(employee);
    }
}
