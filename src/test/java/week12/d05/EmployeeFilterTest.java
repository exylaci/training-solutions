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
                new Employee(0, List.of("programming", "skiing")),
                new Employee(1, List.of("programming", "skiing")),
                new Employee(2, List.of("programming", "skiing")),
                new Employee(3, List.of("programming", "skiing")),
                new Employee(4, List.of("programming", "skiing")))).size());
    }

    @Test
    void countSeniorDevsTest2() {
        EmployeeFilter e = new EmployeeFilter();

        assertEquals(Collections.emptyList(), e.countSeniorDevs(List.of(new Employee(2, List.of("programming", "skiing")))));
    }

    @Test
    void countSeniorDevsTest3() {
        EmployeeFilter e = new EmployeeFilter();

        assertEquals(Collections.emptyList(), e.countSeniorDevs(List.of(new Employee(4, List.of("skiing")))));
    }

    @Test
    void countSeniorDevsTestEmptyList() {
        EmployeeFilter e = new EmployeeFilter();

        assertEquals(Collections.emptyList(), e.countSeniorDevs(new ArrayList<>()));
    }

    @Test
    void countSeniorDevsTestNullInList1() {
        EmployeeFilter e = new EmployeeFilter();

        List<Employee> temp = new ArrayList<>();
        temp.add(null);
        assertEquals(Collections.emptyList(), e.countSeniorDevs(temp));
    }

    @Test
    void countSeniorDevsTestNullInList2() {
        List<String> temp = new ArrayList<>();
        temp.add(null);
        temp.add("programming");

        EmployeeFilter e = new EmployeeFilter();

        assertEquals(2, e.countSeniorDevs(List.of(
                new Employee(0, temp),
                new Employee(1, temp),
                new Employee(2, temp),
                new Employee(3, temp),
                new Employee(4, temp))).size());
    }

    @Test
    void countSeniorDevsTestNullParameter() {
        EmployeeFilter e = new EmployeeFilter();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> e.countSeniorDevs(null));
        assertEquals("Employee list is a must!", exception.getMessage());
    }
}