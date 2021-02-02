package week14.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OnlineShop {
    public static final String SEPARATOR_BUYINGLINE = " ";
    public static final String SEPARATOR_PRODUCTS = ",";

    private Map<String, List<String>> buyings = new HashMap<>();

    public Map<String, List<String>> getBuyings() {
        return buyings;
    }

    public void loadFromFile(Path path) {                                   //0.feladat
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }
        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Can't read from file: " + path);
        }
    }

    private void processOneLine(String oneLine) {
        String[] parts = oneLine.split(SEPARATOR_BUYINGLINE);
        if (parts.length != 2) return;

        String[] products = parts[1].split(SEPARATOR_PRODUCTS);
        List<String> goods = Arrays.stream(products).collect(Collectors.toList());
        buyings.put(parts[0], goods);
    }

    public List<String> getProducts(String id) {                             //1.feladat
        return buyings
                .entrySet()
                .stream()
                .filter(buying -> buying.getKey().equals(id))
                .flatMap(buying -> buying.getValue().stream())
                .sorted(Comparator.comparing(Function.identity())).collect(Collectors.toList());

//        if (buyings.containsKey(id)) {
//            return buyings.get(id).stream().sorted(Comparator.comparing(Function.identity())).collect(Collectors.toList());
//        } else {
//            return Collections.emptyList();
//        }
    }

    public int countSoldPieces(String product) {                             //2.feladat
        return (int) buyings
                .values()
                .stream()
                .flatMap(buyings -> buyings.stream())
                .filter(a -> a.equals(product))
                .count();
    }

    public int countProducts(String id) {                                    //3.feladat
        if (buyings.containsKey(id)) {
            return buyings.get(id).size();
        }
        return 0;
    }

    public Map<String, Long> createStatistic() {                         //4.feladat
        return buyings
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
