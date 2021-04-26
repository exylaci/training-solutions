package gyaxi.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fibonacci {
    public String getPrims(int pieces) {
        if (pieces < 0) {
            throw new IllegalArgumentException("Invalid parameter!");
        }

        List<Integer> fibonacciNumbers = getFibonacci(pieces);

        return fibonacciNumbers.stream()
                .limit(pieces)
                .filter(this::isPrim)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    private boolean isPrim(Integer number) {
        if (number == 1 || number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i < number / 2; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getFibonacci(int pieces) {
        List<Integer> fibonacciNumbers = new ArrayList<>();
        switch (pieces) {
            case 2:
                fibonacciNumbers.add(1);
            case 1:
                fibonacciNumbers.add(1);
            case 0:
                return fibonacciNumbers;
            default:
                fibonacciNumbers = getFibonacci(pieces - 1);
                fibonacciNumbers.add(fibonacciNumbers.get(fibonacciNumbers.size() - 2) + fibonacciNumbers.get(fibonacciNumbers.size() - 1));
                return fibonacciNumbers;
        }
    }

    public List<Integer> getPiecesPrims(int pieces) {
        List<Integer> result = new ArrayList<>();

        if (pieces > 0) {
            result.add(1);
        }
        if (pieces > 1) {
            result.add(1);
        }

        int first = 1;
        int second = 1;
        int current;
        while (result.size() < pieces) {
            current = first + second;
            first = second;
            second = current;
            if (isPrim(current)) {
                result.add(current);
            }
        }
        return result;
    }
}
//1. Vesszővel elválasztva add vissza egy sztringben az első x darab Fibonacci szám közűl a prím számokat!
//
//2. Add vissza egy listában az első x darab prim Fibonacci számot!