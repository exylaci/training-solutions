package week14.d04;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {
    public List<Employee> transformToUppercase(List<Employee> employees) {
        return employees
                .stream()
                .map(employee -> new Employee(employee.getName().toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Employee> transformAsItIsInParameter(List<Employee> employees, Function<Employee, Employee> fn) {
        return employees
                .stream()
                .map(fn::apply)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> temp = List.of(new Employee("Egy"), new Employee("Kettö"));
        EmployeeTransformOperations e = new EmployeeTransformOperations();
        System.out.println(e.transformToUppercase(temp));
        System.out.println(e.transformAsItIsInParameter(temp, employee -> new Employee(employee.getName().toLowerCase())));
        System.out.println(temp);
    }
}
//Írd meg a következő metódust stream használatával!
//
//public class EmployeeTransformOperations {	public List<Employee> transformToUppercased(List<Employee> employees) {
//		return ????;
//	}}
//
//A metódus visszaad egy listát, amiben az alkalmazottak neve nagybetűsítve van.
//Azonban a paraméterként átadott lista ne módosuljon.