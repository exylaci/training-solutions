package week13.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    public static final String SEPARATOR = " ";
    Map<String, Plane> planes = new HashMap<>();

    public Map<String, Plane> getPlanes() {
        return Collections.unmodifiableMap(planes);
    }

    public void loadSchedule(Path path) {
        if (path == null) throw new IllegalArgumentException("Path is a must!");

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file: " + path);
        }
    }

    private void processOneLine(String oneLine) {
        String[] parts = oneLine.split(SEPARATOR);
        if (parts.length < 4) return;


        planes.put(parts[0], new Plane(parts[0], parts[1], parts[2], parts[3]));
    }

    public Direction getMoreDirection() {
        Map<Direction, Long> directions = planes
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(a -> a.getValue().getDirection(), Collectors.counting()));
        if (directions.get(Direction.ARRIVAL) > directions.get(Direction.DEPARTURE)) {
            return Direction.ARRIVAL;

        }
        return Direction.DEPARTURE;
    }

    public Plane getPlaneByID(String ID) {
        return planes.get(ID);
    }

    public List<Plane> collectPlanesByCity(Scanner scanner) {
        String city = askCity(scanner);
        Direction direction = askDirection(scanner);
        if (direction == null) return Collections.emptyList();

        return planes
                .values()
                .stream()
                .filter(plane -> plane.getDirection() == direction)
                .filter(plane -> plane.getCity().equals(city))
                .collect(Collectors.toList());
    }

    private Direction askDirection(Scanner scanner) {
        System.out.print("Select direction (1: " + Direction.values()[0] + ", 2: " + Direction.values()[1] + ")");
        switch (scanner.nextInt()) {
            case 1:
                return Direction.ARRIVAL;
            case 2:
                return Direction.DEPARTURE;
        }
        return null;
    }

    private String askCity(Scanner scanner) {
        System.out.print("Which city: ");
        String city = scanner.nextLine();
        return city;
    }

    public Plane getEarliestDeparture() {
        Optional<Plane> result = planes
                .values()
                .stream()
                .filter(plane -> plane.getDirection() == Direction.DEPARTURE)
                .min((a, b) -> a.getTime().isBefore(b.getTime()) ? -1 : 1);

        if (result.isPresent()) {
            return result.get();
        }
        throw new IllegalArgumentException("There is no plane at all!");
    }

    public static void main(String[] args) {
        Airport a = new Airport();
        a.collectPlanesByCity(new Scanner(System.in));

        System.out.println(LocalDateTime.parse("16:30", DateTimeFormatter.ofPattern("HH:mm")));
    }
}
//Adott egy fájl melyben egy reptér egy napi munkáját rögzítettük. Adott egy járatszám, az, hogy érkező vagy felszálló
// gépről van-e szó. A kiinduló/cél város, attól függöen hogy indul vagy érkezik-e a gép és a felszállás/leszállás
// pontos ideje.
//
//A fájl:
//FC5354 Arrival Dublin 18:16
//KH2442 Departure Berlin 15:54
//ID4963 Departure Amsterdam 15:22
//CX8486 Arrival Brussels 10:37
//EJ9251 Departure  Toronto 11:30
//KJ7245 Departure Bern 6:18
//JN6048 Arrival Moscow 18:39
//MN5047 Arrival Athens 9:35
//
//Az időpontok szándékosan így szereplnek, nincsenek nullák a számok előtt. Az adatok össze vissza szerepelnek a fájlban.

//Feladatok:
//1. Olvasd be a fájl tartalmát a memóriába.
//2. Határozd meg, hogy induló vagy érkező járatból volt-e több.
//3. Legyen egy metódus ami járatszám alapján ad vissza egy repülőt.
//4. Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e. És egy Listába
//   adjuk viassza az összes abba városba induló/érkező repülőt.
//5. Adjuk vissza a legkorábban induló repülőt!