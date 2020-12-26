package week08.d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LotteryTest {
    @Test
    void getNumbersTest() {
        List<Integer> numbers = Lottery.getNumbers();
        for (int i = 0; i < 5; ++i) {
            for (int j = i + 1; j < 5; ++j) {
                assertFalse(numbers.get(i) == numbers.get(j));
            }
        }
    }

    @Test
    void getNumbers2Test() {
        List<Integer> sample = List.of(15, 20, 21, 38, 36);

        List<Integer> numbers = Lottery.getNumbers(90, 5, 3);
        for (int i =0; i < 5; ++i) {
            assertTrue(numbers.get(i) == sample.get(i));
        }
    }

    @Test
    void getNumbersPlusTest() {
        List<Integer> numbers = Lottery.getNumbers(90, 5);
        for (int i = 0; i < 5; ++i) {
            for (int j = i + 1; j < 5; ++j) {
                assertFalse(numbers.get(i) == numbers.get(j));
            }
        }
    }

    @Test
    void getNumbersExtremTest() {
        List<Integer> numbers = Lottery.getNumbers(10, 10);
        for (int i = 0; i < 10; ++i) {
            for (int j = i + 1; j < 10; ++j) {
                assertFalse(numbers.get(i) == numbers.get(j));
            }
        }
    }

    @Test
    void getNumbersImpossibleTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Lottery.getNumbers(1, 2));
        assertEquals("Impossible conditions!", exception.getMessage());
    }
}