package gyaxi.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzz {

    // Egyszerűen bővíthető akárhány feltétellel
    public List<String> letsPlay(int step) {
        return Stream
                .iterate(1, n -> n + 1)
                .limit(step)
                .map(String::valueOf)
                .map(this::divByThree)
                .map(this::divByFive)
                .map(this::getResult)
                .collect(Collectors.toList());
    }

    private String divByThree(String item) {
        int number = Integer.parseInt(item);
        if (number % 3 == 0) {
            return item + ",Fizz";
        }
        return item + ",";
    }

    private String divByFive(String item) {
        String[] parts = item.split(",");
        int number = Integer.parseInt(parts[0]);
        if (number % 5 == 0) {
            item += "Buzz";
        }
        return item;
    }

    private String getResult(String item) {
        String[] parts = item.split(",");
        if (parts.length == 1) {
            return parts[0];
        }
        return parts[1];
    }

    // Növekvő feltétel szám esetén, egyre bonyolultabb if
    public List<String> letsPlay2(int step) {
        return Stream
                .iterate(1, n -> n + 1)
                .limit(step)
                .map(this::checkFizzBuzz)
                .collect(Collectors.toList());
    }

    private String checkFizzBuzz(Integer number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    // Minden egyben a stream-ben. Nem túlságosan "clean code".
    public List<String> letsPlay3(int steps) {
        return Stream
                .iterate(1, n -> n + 1)
                .limit(steps)
                .map((i) -> i % 3 == 0 && i % 5 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : String.valueOf(i))
                .collect(Collectors.toList());
    }

    // klasszikus forciklussal
    public List<String> letsPlay4(int steps) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= steps; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}