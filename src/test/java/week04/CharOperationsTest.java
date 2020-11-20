package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

public class CharOperationsTest {

    @Test
    public void charOperationsTestOne() {
        CharOperations charOperations = new CharOperations();
        List<Integer> result = Arrays.asList(0,3);
        Assertions.assertEquals(result,  charOperations.getPositionsOfChar("alma","a") );
    }

    @Test
    public void charOperationsTestLonger() {
        CharOperations charOperations = new CharOperations();
        List<Integer> result = Arrays.asList(0);
        Assertions.assertEquals(result,  charOperations.getPositionsOfChar("alma","al") );
    }

    @Test
    public void charOperationsTestLongerAtEnd() {
        CharOperations charOperations = new CharOperations();
        List<Integer> result = Arrays.asList(2);
        Assertions.assertEquals(result,  charOperations.getPositionsOfChar("alma","ma") );
    }
}
