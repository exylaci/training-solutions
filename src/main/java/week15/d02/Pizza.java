package week15.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Pizza {
    private List<Curier> pizzas = new ArrayList<>();
    Curier curier;
    private Map<LocalDate, Integer> days = new HashMap<>();

    public void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }
            System.out.println(pizzas);
            ;

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!");
        }
    }

    private void processOneLine(String oneLine) {
        if (oneLine.contains(".")) {
            if (curier != null) {
                pizzas.add(curier);
            }
            curier = new Curier(oneLine);
            days.put(curier.getTime().toLocalDate(), 0);
            return;
        }
        if (oneLine.contains(" ")) {
            String[] parts = oneLine.split(" ");
            curier.setAddress(parts);
            curier.setTime(parts[parts.length - 1]);
            pizzas.add(curier);
            curier = new Curier(curier);
            days.put(curier.getTime().toLocalDate(), days.get(curier.getTime().toLocalDate())+1);
            return;
        }
        curier.setId(oneLine);
    }

    public LocalDate getMinOrderDay(){
        int min=Integer.MAX_VALUE;
        LocalDate result = null;
        for(Map.Entry<LocalDate,Integer> entry : days.entrySet()){
            if(entry.getValue()<min){
                min=entry.getValue();
                result=entry.getKey();
            }
        }
        return result;
    }

    public Optional<Curier> getOrder(LocalDateTime time){
        for(Curier c : pizzas){
            if(c.getTime().equals(time)){
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        Pizza p = new Pizza();
        p.readFile(Path.of("src/main/resources/orders.txt"));
        System.out.println(p.getMinOrderDay());
        System.out.println(p.getOrder(LocalDateTime.of(2020,12,01,16,33)).get());
    }

}
