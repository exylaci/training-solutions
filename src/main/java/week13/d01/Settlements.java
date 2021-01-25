package week13.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.*;

public class Settlements {
    private List<Settlement> settlements = new ArrayList<>();

    public void loadFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            settlements.clear();

            String oneLine;

            String droppedFirstLine = reader.readLine();
            while ((oneLine = reader.readLine()) != null) {
                settlements.add(new Settlement(oneLine));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from " + e);
        }
    }

    public Settlement getFirst() {
        List<Settlement> temp = new ArrayList<>(settlements);

        temp.sort(Comparator.comparing(
                Settlement::getName,
                Comparator.nullsLast(Collator.getInstance(new Locale("hu", "HU")))));

        return temp.get(0);
    }

    public Settlement getLongestName() {
        List<Settlement> temp = new ArrayList<>(settlements);

        temp.sort(Comparator.comparing(
                Settlement::getName,
                Comparator.comparingInt(String::length).reversed()));

        return temp.get(0);
    }
}
//A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok
// listáját.
//
// Add vissza az ábécésorrendben első város nevét és irányítószámát!
// Add vissza a leghosszabb nevű várost!
//
//A fájl innen tölthető le:
// https://github.com/Training360/strukturavalto-java-public/blob/master/examples/week13d01/src/main/resources/iranyitoszamok-varosok-2021.csv