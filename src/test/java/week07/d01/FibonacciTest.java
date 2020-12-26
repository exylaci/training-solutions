package week07.d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {
    @Test
    void fibonacciTest() {

        assertEquals(0, Fibonacci.fib(0));
        assertEquals(1, Fibonacci.fib(1));
        assertEquals(1, Fibonacci.fib(2));
        assertEquals(2, Fibonacci.fib(3));
        assertEquals(3, Fibonacci.fib(4));
        assertEquals(5, Fibonacci.fib(5));
        assertEquals(8, Fibonacci.fib(6));
        assertEquals(13, Fibonacci.fib(7));
        assertEquals(7540113804746346429L, Fibonacci.fib(92));
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Fibonacci.fib(93));
        assertEquals("Túl sokadik elemet kéred. :(", exception.getMessage());
    }

    @Test
    void fibonacciRecursiveTest() {

        assertEquals(0, Fibonacci.fibRecursive(0));
        assertEquals(1, Fibonacci.fibRecursive(1));
        assertEquals(1, Fibonacci.fibRecursive(2));
        assertEquals(2, Fibonacci.fibRecursive(3));
        assertEquals(3, Fibonacci.fibRecursive(4));
        assertEquals(5, Fibonacci.fibRecursive(5));
        assertEquals(8, Fibonacci.fibRecursive(6));
        assertEquals(13, Fibonacci.fibRecursive(7));
        assertEquals(7540113804746346429L, Fibonacci.fibRecursive(92));
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Fibonacci.fibRecursive(93));
        assertEquals("Túl sokadik elemet kéred. :(", exception.getMessage());
    }
}