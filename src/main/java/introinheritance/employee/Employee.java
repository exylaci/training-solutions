package introinheritance.employee;

public class Employee extends Person {
    private double salary;

    public Employee(String name, String address, double salary) {
        super(name, address);
        this.salary = salary;
    }

    public void raiseSalary(int percent) {
        salary *= 1 + percent / 100.;
    }

    public double getSalary() {
        return salary;
    }

}
