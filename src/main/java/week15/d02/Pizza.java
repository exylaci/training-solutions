package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Pizza {
    public static final char DATE_SEPARATOR = '.';
    public static final String ADDRESS_SEPARATOR = " ";

    private List<Order> orders = new ArrayList<>();
    private Order order;

    public Pizza() {
    }

    public void readFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine.trim());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!");
        }
    }

    private void processOneLine(String oneLine) {
        if (oneLine.matches("[0-9]{4}.[0-9]{1,2}.[0-9]{1,2}")) {
            processDateLine(oneLine);
            return;
        }
        if (oneLine.contains(" ")) {
            processAddressAndTimeLine(oneLine);
            return;
        }
        processCourierLine(oneLine);
    }

    private void processDateLine(String oneLine) {
        if (order != null && order.getTime() != null) {
            orders.add(order);
        }
        order = new Order(oneLine);
    }

    private void processAddressAndTimeLine(String oneLine) {
        String[] parts = oneLine.replace("  ", " ").trim().split(ADDRESS_SEPARATOR);
        order.setAddress(parts);
        order.setTime(parts[parts.length - 1]);
        orders.add(order);
        order = new Order(order.getDate());
    }

    private void processCourierLine(String oneLine) {
        order.setCourier(oneLine);
    }

    public Map<String, Long> makeCourierStatistic() {
        return orders
                .stream()
                .collect(Collectors.groupingBy(Order::getCourier, Collectors.counting()));
    }

    public LocalDate getMinOrderDay() {
        Optional<Map.Entry<LocalDate, Long>> result = orders
                .stream()
                .collect(Collectors.groupingBy(Order::getDate, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Comparator.comparingInt(entry -> Math.toIntExact(entry.getValue())));
        if (result.isPresent()) {
            return result.get().getKey();
        }
        throw new IllegalStateException("There is no orders!");
    }

    public String getMostFrequentlyAddress() {
        if (orders.size() == 0) throw new IllegalStateException("There is no orders!");
        return orders
                .stream()
                .collect(Collectors.groupingBy(Order::getAddress, Collectors.counting()))
                .entrySet()
                .stream()
                .max((a, b) -> Math.toIntExact(a.getValue()) - Math.toIntExact(b.getValue()))
                .get()
                .getKey();
    }

    public Optional<Order> getOrderByDateAndTime(LocalDate date, LocalTime time) {
        for (Order c : orders) {
            if (c.getDate().equals(date) && c.getTime().equals(time)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    //only for tests
    public Pizza(List<Order> orders) {
        this.orders = orders;
    }

    //only for tests
    public List<Order> getOrders() {
        return orders;
    }
}
//Adott egy fájl melyben pizza rendeléseket tárolunk. A fájl blokkokra van osztva, egy blokk egy napot jelöl, és minden
// ilyen blokk egy dátummal kezdődik. Ezután egy rendelés adatai két sorban találhatók. Az első sor a futár azonosítója,
// a második sorban irányítószám, utcanév, házszám és a szállítás pontos ideje található.
//
//2020.12.01
//FUT_1
//1113 Petőfi 12 12:30
//FUT_2
//1114 Kossuth 9 11:20
//FUT_2
//1211 Jókai 10 19:30
//FUT_3
//1191 Kossuth 9 18:12
//FUT_1
//1144 Tököly 11 16:33
//2020.12.02
//FUT_1
//1123 Ady 12 12:30
//....
//
//A fájl beolvasása után oldjátok meg a következő feladatokat!
//1. Melyik napon volt a legkevesebb rendelés?
//2. Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést. Ha nincs
//   ilyen akkor dobjunk kivételt. (Vagy Optional)
//3. Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek.
//4. Melyik címre szállították a legtöbb pizzát?