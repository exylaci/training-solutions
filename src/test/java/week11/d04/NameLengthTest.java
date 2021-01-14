package week11.d04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameLengthTest {
    @Test
    void getLengthsExtremeDataTest() {
        NameLength n = new NameLength();
        assertEquals(Collections.emptyList(), n.getLengths(null));
        assertEquals(Collections.emptyList(), n.getLengths(List.of("")));

        List<String> temp = new ArrayList<>();
        temp.add(null);
        assertEquals(Collections.emptyList(), n.getLengths(temp));
    }

    @Test
    void getLengthsNormalTest() {
        NameLength n = new NameLength();
        List<Integer> result = n.getLengths(List.of("Jack", "Joe", "Jane", "Jake", "George", "William"));

        assertEquals(2, result.size());
        assertEquals(3, result.get(0));
        assertEquals(4, result.get(1));
    }
}