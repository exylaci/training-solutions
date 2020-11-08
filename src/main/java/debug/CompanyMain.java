package debug;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Gábor Áron",1848));
        employees.add(new Employee("Nagy Lajos",1823));
        Company company = new Company(employees);
        company.addEmployee(new Employee("Lajos Imre",1817));
        company.addEmployee(new Employee("Gábor Zsazsa",1945));
        for ( String name : company.listEmployeeNames() ) {
            System.out.println(name);
        }

        System.out.println("Gábor Áron ? " + company.findEmployeeByName("Gábor Áron") );
        System.out.println("gábor áron ? " + company.findEmployeeByName("gábor áron") );
        System.out.println("Gábor      ? " + company.findEmployeeByName("Gábor") );
    }
}
