package week04.d02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SearchTest {

    @Test
    public void charOperationsTestOne() {
        Search charOperations = new Search();
        List<Integer> result = Arrays.asList(0, 3);
        Assertions.assertEquals(result, charOperations.getIndexesOfChar("alma", "a"));
    }

    @Test
    public void charOperationsTestLonger() {
        Search charOperations = new Search();
        List<Integer> result = Arrays.asList(0);
        Assertions.assertEquals(result, charOperations.getIndexesOfChar("alma", "al"));
    }

    @Test
    public void charOperationsTestLongerAtEnd() {
        Search charOperations = new Search();
        List<Integer> result = Arrays.asList(2);
        Assertions.assertEquals(result, charOperations.getIndexesOfChar("alma", "ma"));
    }
}