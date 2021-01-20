package week12.d03;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberStat {
    public static final String SPLITTER = ",";

    List<Integer> list;

    public NumberStat(List<Integer> list) {
        this.list = list;
    }

    public int findSmallestUnique() {
        if (list == null) throw new IllegalArgumentException("The list is a must!");

        Optional<Map.Entry<Integer, Long>> result = list
                .stream()
                .filter(a -> a != null)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(a -> a.getValue() == 1)
                .min((a, b) -> (int) (a.getKey() - b.getKey()));

        if (result.isPresent()) {
            return result.get().getKey();
        }

        throw new IllegalStateException("There is no unique element in this list.");
    }

    public void loadFromFile(Path pathAndFileName) {
        if (pathAndFileName == null) throw new IllegalArgumentException("The file name is a must!");

        try (BufferedReader reader = Files.newBufferedReader(pathAndFileName)) {
            list = new ArrayList<>();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                process(oneLine);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + pathAndFileName);
        }

    }

    private void process(String oneLine) {
        String[] parts = oneLine.split(SPLITTER);
        for (String oneData : parts) {
            addOneData(oneData);
        }
    }

    private void addOneData(String oneData) {
        try {
            list.add(Integer.parseInt(oneData));
        } catch (NumberFormatException e) {
//            System.out.println("This data isn't a number in the file: "+oneData);
        }

    }

    public List<Integer> getList() {
        return list;
    }

}
//Készítsd el a week12d03.NumberStat osztályt melyben legyen egy metódus, ami paraméterül vár egy egész számokból álló
// listát. Add vissza azt a számot amelyik pontosan egyszer szerepel a listában. Ha több ilyen szám van akkor a kisebbet!
//
//pl: {1,1,5,3,4,5,6,5,6,4,1,6,5,4} A megoldás: 3