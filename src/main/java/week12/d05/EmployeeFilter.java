package week12.d05;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFilter {

    public List<Employee> countSeniorDevs(List<Employee> employees) {
        if (employees == null) throw new IllegalArgumentException("Employee list is a must!");
        return employees
                .stream()
                .filter(employee -> employee != null)
                .filter(employee -> employee.getSkillLevel() >= 3)
                .filter(employee->employee.getSkills().stream().filter(skill->skill.equals("programming")).count()>0)
                .collect(Collectors.toList());
    }
}
//Adott az alábbi osztály:
//
//public class Employee {
//    private int age;
//    private int skillLevel;
//    private String name;
//    private List<String> skills;
//}
//
//Készítsetek az EmployeeFilter osztályba egy List<Employee> countSeniorDevs(List<Employee> employees) metótust,
// mely a megadott employees-ből kiválogatja a senior (ahol a skill level nagyobb, vagy egyenlő, mint 3) fejlesztőket.
// A fejlesztők rendelkeznek a programming skill-lel.