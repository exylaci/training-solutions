package week15.d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameOfThrones {
    public static final String SEPARATOR = ",";

    private List<Bottles> bottles = new ArrayList<>();

    public Optional<String> findMostFightingHouseByStream(Path path) {
        try (Stream<String> combats = Files.lines(path, StandardCharsets.US_ASCII)) {
            Optional<Map.Entry<String, Long>> house = combats
                    .skip(1)
                    .filter(oneLine -> !oneLine.isBlank())
                    .flatMap(this::getHouses)
                    .filter(oneHouse -> !oneHouse.isBlank())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max((a, b) -> (int) (a.getValue() - b.getValue()));

            if (house.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(house.get().getKey());

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file");
        }
    }

    private Stream<String> getHouses(String oneLine) {
        String[] parts = oneLine.replace(", ","§§").split(",");
        String[] houses = Arrays.copyOfRange(parts,5,13);
        return Arrays.stream(houses);
    }

    public void loadFromFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            skipHeader(reader);

            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!");
        }
    }

    private void processOneLine(String oneLine) {
        String[] parts = oneLine.split(SEPARATOR);
        List<String> cells = new ArrayList<>();
        StringBuilder cellsMerger = new StringBuilder();
        for (String cell : parts) {
            if (cell.startsWith("\"") && cell.endsWith("\"")) {
                cell = cell.substring(1, cell.length() - 1);
            }
            if (cell.startsWith("\"")) {
                cellsMerger.append(cell.substring(1)).append(SEPARATOR);
            } else if (cell.endsWith("\"")) {
                cellsMerger.append(cell, 0, cell.length() - 1);
                cells.add(cellsMerger.toString());
                cellsMerger = new StringBuilder();
            } else if (cellsMerger.isEmpty()) {
                cells.add(cell);
            } else {
                cellsMerger.append(cell).append(SEPARATOR);
            }
        }
        bottles.add(new Bottles(cells));
    }

    private void skipHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }

    public String findMostFightingHouse() {
        Map<String, Integer> fightsCounter = new HashMap<>();
        for (Bottles bottle : bottles) {
            invokeHousesAndIncreaseFights(fightsCounter, bottle.getAttackers());
            invokeHousesAndIncreaseFights(fightsCounter, bottle.getDefenders());
        }

        String house = null;
        int max = 0;
        for (Map.Entry<String, Integer> fight : fightsCounter.entrySet()) {
            if (max < fight.getValue()) {
                max = fight.getValue();
                house = fight.getKey();
            }
        }
        return house;
    }

    private void invokeHousesAndIncreaseFights(Map<String, Integer> fightsCounter, List<String> houses) {
        for (String hause : houses) {
            if (!fightsCounter.containsKey(hause)) {
                fightsCounter.put(hause, 0);
            }
            fightsCounter.replace(hause, fightsCounter.get(hause) + 1);
        }
    }

    public List<Bottles> getBottles() {
        return Collections.unmodifiableList(bottles);
    }
}
//Adott egy fájl a következő címen:
// https://raw.githubusercontent.com/TheMLGuy/Game-of-Thrones-Dataset/master/battles.csv
// Melyik ház vett részt a legtöbb csatában?