package week14.d03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

    static ClassNotebook c = new ClassNotebook();

    @BeforeAll
    static void init() {
        c.addStudent("Sándor");
        c.addStudent("Ági");
        c.addStudent("Laci");
        c.addStudent("Andi");

        c.addMark("Sándor","matek",4);
        c.addMark("Sándor","matek",2);
        c.addMark("Sándor","fizika",1);
    }

    @Test
    void addMarkTest() {
        Exception exception = assertThrows(IllegalArgumentException.class,()->
                        c.addMark(null,"fizika",2));
        assertEquals("Can't find student: null",exception.getMessage());
    }

    @Test
    void sortNotebookTest() {
        List<Student> s = c.sortNotebook();

        s.get(0).addMark("rajz",1);
        System.out.println(s);
        System.out.println(c.sortNotebook());
    }
}