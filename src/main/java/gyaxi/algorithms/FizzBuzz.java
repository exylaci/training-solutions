package gyaxi.algorithms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FizzBuzz {

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
}
