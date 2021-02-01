package week14.d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransformersTest {

    @Test
    void map() {
        List<Integer> expected1 = List.of(2, 3, 4);
        List<Integer> source1 = Arrays.asList(1, 2, 3);
        assertEquals(expected1, new Transformers().map(source1, (value) -> value + 1));

        List<Integer> expected2 = List.of(3, 5, 5);
        List<String> source2 = Arrays.asList("egy", "kettő", "harom");
        assertEquals(expected2, new Transformers().map(source2, String::length));
    }

    @Test
    void reduce() {
        System.out.println(new Transformers().reduce(Arrays.asList(1, 2, 3), 0, Integer::sum));
    }
}