package gyaxi.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void letsPlay0() {
        List<String> result = new FizzBuzz().letsPlay(0);

        assertEquals(Collections.EMPTY_LIST, result);
    }

    @Test
    void letsPlay47() {
        List<String> result = new FizzBuzz().letsPlay(148);

        assertEquals(148, result.size());
    }

    @Test
    void letsPlay20() {
        List<String> result = new FizzBuzz().letsPlay(20);

        assertEquals(20, result.size());
        assertEquals("11", result.get(10));
        assertEquals("Fizz", result.get(8));
        assertEquals("Buzz", result.get(9));
        assertEquals("FizzBuzz", result.get(14));
    }
}