package week12.d05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFilterTest {

    @Test
    void countSeniorDevsTest1() {
        EmployeeFilter e = new EmployeeFilter();

        assertEquals(2, e.countSeniorDevs(List.of(
                new Employee("Józsi", 0),
                new Employee("Éva", 1),
                new Employee("Sanyi", 2),
                new Employee("Dezső", 3),
                new Employee("Én :)", 4))).size());
    }

    @Test
    void countSeniorDevsTest2() {
        EmployeeFilter e = new EmployeeFilter();

        assertEquals(Collections.emptyList(), e.countSeniorDevs(List.of(new Employee("Józsi", 0))));
    }

    @Test
    void countSeniorDevsTestEmptyList() {
        EmployeeFilter e = new EmployeeFilter();

        assertEquals(Collections.emptyList(), e.countSeniorDevs(new ArrayList<>()));
    }

    @Test
    void countSeniorDevsTestNullInList() {
        EmployeeFilter e = new EmployeeFilter();

        List<Employee> temp = new ArrayList<>();
        temp.add(null);
        assertEquals(Collections.emptyList(), e.countSeniorDevs(temp));
    }

    @Test
    void countSeniorDevsTestNullParameter() {
        EmployeeFilter e = new EmployeeFilter();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> e.countSeniorDevs(null));
        assertEquals("Employee list is a must!", exception.getMessage());
    }
}