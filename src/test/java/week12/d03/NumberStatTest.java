package week12.d03;

import org.junit.jupiter.api.Test;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {
    @Test
    void findSmallestUniqueTest1() {
        NumberStat n = new NumberStat(List.of(1, 1, 1, 5, 3, 5, 6, 5, 5, 6, 1, 6, 5, 4));
        assertEquals(3, n.findSmallestUnique());
    }

    @Test
    void findSmallestUniqueTest2() {
        NumberStat n = new NumberStat(List.of(1));
        assertEquals(1, n.findSmallestUnique());
    }

    @Test
    void findSmallestUniqueTest3() {
        NumberStat n = new NumberStat(List.of(2, 1));
        assertEquals(1, n.findSmallestUnique());
    }

    @Test
    void findSmallestUniqueNullInListTest() {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(null);
        temp.add(2);
        NumberStat n = new NumberStat(temp);

        assertEquals(1, n.findSmallestUnique());
    }

    @Test
    void findSmallestUniqueNoUniqueTest() {
        NumberStat n = new NumberStat(List.of(1, 1, 2, 2));

        Exception exception = assertThrows(IllegalStateException.class, n::findSmallestUnique);
        assertEquals("There is no unique element in this list.", exception.getMessage());
    }

    @Test
    void findSmallestUniqueEmptyListTest() {
        NumberStat n = new NumberStat(new ArrayList<>());

        Exception exception = assertThrows(IllegalStateException.class, n::findSmallestUnique);
        assertEquals("There is no unique element in this list.", exception.getMessage());
    }

    @Test
    void findSmallestUniqueOnlyNullInListParameterTest() {
        List<Integer> temp = new ArrayList<>();
        temp.add(null);
        NumberStat n = new NumberStat(temp);

        Exception exception = assertThrows(IllegalStateException.class, n::findSmallestUnique);
        assertEquals("There is no unique element in this list.", exception.getMessage());
    }

    @Test
    void findSmallestUniqueNullParameterTest() {
        NumberStat n = new NumberStat(null);

        Exception exception = assertThrows(IllegalArgumentException.class, n::findSmallestUnique);
        assertEquals("The list is a must!", exception.getMessage());
    }

    @Test
    void loadFromFileTest() {
        NumberStat n = new NumberStat(null);

        n.loadFromFile(Path.of("src/main/resources/week12/d03/numbers.txt"));

        assertEquals(List.of(1, 1, 4, 2, 3, 5, 2, 2, 5, 645, 744, 322, 21, 4, 56, 3, -34, -67, 0, -1, -3, 5),
                n.getList());
    }

    @Test
    void loadFromFileInvalidFileNameTest() {
        NumberStat n = new NumberStat(null);

        Exception exception = assertThrows(IllegalStateException.class, () -> n.loadFromFile(Path.of("")));
        assertEquals("Can't read from file: ", exception.getMessage());
    }

    @Test
    void loadFromFileParameterTest() {
        NumberStat n = new NumberStat(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> n.loadFromFile(null));
        assertEquals("The file name is a must!", exception.getMessage());
    }
}
