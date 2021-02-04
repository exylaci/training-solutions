package week14.d04;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {
    public List<Employee> transformToUppercase(List<Employee> employees){
        return employees
                .stream()
                .map(employee -> employee.getName().toUpperCase())
                .map(a->new Employee(a))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> temp = List.of(new Employee("egy"),new Employee("kettö"));
        EmployeeTransformOperations e = new EmployeeTransformOperations();
        System.out.println(e.transformToUppercase(temp));
        System.out.println(temp);
    }
}
