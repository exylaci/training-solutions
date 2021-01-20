package week12.d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberStatTest {
    @Test
    void findSmallestUniqueTest() {
        NumberStat n = new NumberStat();

        assertEquals(3, n.findSmallestUnique(List.of(1, 1, 1, 5, 3, 5, 6, 5, 5, 6, 1, 6, 5, 4)));
        assertEquals(1, n.findSmallestUnique(List.of(1)));
        assertEquals(1, n.findSmallestUnique(List.of(2, 1)));
    }

    @Test
    void findSmallestUniqueNullInListTest() {
        NumberStat n = new NumberStat();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(null);
        temp.add(2);

        assertEquals(1, n.findSmallestUnique(temp));
    }

    @Test
    void findSmallestUniqueNoUniqueTest() {
        NumberStat n = new NumberStat();

        Exception exception = assertThrows(IllegalStateException.class, () -> n.findSmallestUnique(List.of(1, 1, 2, 2)));
        assertEquals("There is no unique element in this list.", exception.getMessage());
    }

    @Test
    void findSmallestUniqueEmptyListTest() {
        NumberStat n = new NumberStat();

        Exception exception = assertThrows(IllegalStateException.class, () -> n.findSmallestUnique(new ArrayList<Integer>()));
        assertEquals("There is no unique element in this list.", exception.getMessage());
    }

    @Test
    void findSmallestUniqueOnlyNullInListParameterTest() {
        NumberStat n = new NumberStat();
        List<Integer> temp = new ArrayList<>();
        temp.add(null);

        Exception exception = assertThrows(IllegalStateException.class, () -> n.findSmallestUnique(temp));
        assertEquals("There is no unique element in this list.", exception.getMessage());
    }

    @Test
    void findSmallestUniqueNullParameterTest() {
        NumberStat n = new NumberStat();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> n.findSmallestUnique(null));
        assertEquals("The list is a must!", exception.getMessage());
    }
}
