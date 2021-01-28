package week13.d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    void merge() {
        Path path = Path.of("src/main/resources/week13/d04/EmployeeTemplate.txt");

        List<Employee> employees = List.of(
                new Employee("Jucika drága", 1981),
                new Employee("Gizike", 1999),
                new Employee("Gábor Áron", 1848),
                new Employee("ki más?", 2007));


        String expected = """
                Az alkalmazott neve: Jucika drága, születési éve: 1981
                Az alkalmazott neve: Gizike, születési éve: 1999
                Az alkalmazott neve: Gábor Áron, születési éve: 1848
                Az alkalmazott neve: ki más?, születési éve: 2007
                                """;
        assertEquals(expected, new TemplateMerger().merge(path, employees));
    }
}