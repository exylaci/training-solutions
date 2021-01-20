package week12.d03;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberStat {

    public int findSmallestUnique(List<Integer> list) {
        if (list == null) throw new IllegalArgumentException("The list is a must!");

        Optional<Map.Entry<Integer, Long>> result = list
                .stream()
                .filter((a) -> a != null)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(a -> a.getValue() == 1)
                .min((a, b) -> (int) (a.getValue() - b.getValue()));

        if (result.isPresent()) {
            return result.get().getKey();
        }

        throw new IllegalStateException("There is no unique element in this list.");
    }
}
//Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus, ami paraméterül vár egy egész számokból álló
// listát. Add vissza azt a számot amelyik pontosan egyszer szerepel a listában. Ha több ilyen szám van akkor a kisebbet!
//
//pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3