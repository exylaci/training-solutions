package erettsegik.majus2019.cegesautok;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm");

    private List<CarPark> parks;
    private Scanner scanner = new Scanner(System.in);

    public Main() {
    }

    public Main(List<CarPark> parks, Scanner scanner) {
        this.parks = parks;
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.excercrise1("autok.txt");
            main.excercrise2();
            main.excercrise3();
            main.excercrise4();
            main.excercrise5();
            main.excercrise6();
            main.excercrise7();

        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }

    public List<CarPark> getParks() {
        return parks;
    }

    public void excercrise1(String fileName) {
        System.out.println("\n1. feladat");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName), StandardCharsets.UTF_8))) {

            parks = new ArrayList<>();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                parks.add(CarPark.of(oneLine));
            }
            System.out.println("\tA fájl beolvasásva.");

        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Fájlolvasási hiba!", e);
        }
    }

    public void excercrise2() {
        System.out.println("\n2. feladat");


        Optional<CarPark> last = findTheLastOutCar();
        if (last.isPresent()) {
            System.out.printf("\t%d. nap rendszám: %s%n", last.get().getDay(), last.get().getPlateNumber());
        } else {
            System.out.println("\tNem vittek ki autót a garázsból.");
        }

        //Ez az "unalmas" megoldás:
        //int last = parks.size() - 1;
        //while (parks.get(last).getDirection() != Direction.OUT) {
        //    last -= 1;
        //    if (last < 0) {
        //        System.out.println("\tNem vittek ki autót a garázsból.");
        //        return;
        //    }
        //}
        //System.out.printf("\t%d. nap rendszám: %s%n", parks.get(last).getDay(), parks.get(last).getPlateNumber());
    }

    public Optional<CarPark> findTheLastOutCar() {
        return parks
                .stream()
                .filter(carPark -> carPark.getDirection() == Direction.OUT)
                .max(Comparator.comparing(CarPark::getDay).thenComparing(CarPark::getTime));
    }

    public void excercrise3() {
        System.out.println("\n3. feladat");

        System.out.print("\tKérem a listázandó napot: ");
        String day = scanner.nextLine();

        if (!day.matches("[0-9]{1,2}") || Integer.parseInt(day) > 30) {
            System.out.println("Nem megfelelő adat!");
            return;
        }

        List<CarPark> result = getCarsOnADay(Integer.parseInt(day));
        System.out.printf("\tForgalom a(z) %s. napon:%n", day);
        for (CarPark carPark : result) {
            System.out.printf("\t%s %s %3d %s%n",
                    carPark.getTime().format(TIME_FORMAT),
                    carPark.getPlateNumber(),
                    carPark.getEmployeeId(),
                    carPark.getDirection().getDirection());
        }
    }

    public List<CarPark> getCarsOnADay(int day) {
        return parks
                .stream()
                .filter(carPark -> carPark.getDay() == day)
                .collect(Collectors.toList());
    }

    public void excercrise4() {
        System.out.println("\n4. feladat");

        //általános megoldás
        Map<String, Direction> cars = new HashMap<>();
        for (CarPark carPark : parks) {
            cars.put(carPark.getPlateNumber(), carPark.getDirection());
        }

        int counter = 0;
        for (Map.Entry<String, Direction> car : cars.entrySet()) {
            if (car.getValue() == Direction.OUT) {
                ++counter;
            }
        }

        //Ha fent áll az a feltétel, hogy a hónap elején minden autó bent áll a cég parkolójában:
        //
        //int counter = 0;
        //for (CarPark carPark : parks) {
        //    if (carPark.getDirection() == Direction.IN) {
        //        --counter;
        //    } else {
        //        ++counter;
        //    }
        //}

        System.out.printf("\tA hónap végén %d autót nem hoztak vissza.%n", counter);
    }

    private void excercrise5() {
        System.out.println("\n5. feladat");

        Map<String, Integer> distances = getDistances();

        System.out.printf("\t%6s %s%n", "frsz", "megtett táv");
        for (Map.Entry<String, Integer> distance : distances.entrySet()) {
            System.out.printf("\t%6s %5d km%n", distance.getKey(), distance.getValue());
        }
    }

    public Map<String, Integer> getDistances() {
        Map<String, Integer> distances = new TreeMap<>();
        Map<String, Integer> meters = new HashMap<>();
        String plateNumber;
        for (CarPark carPark : parks) {
            plateNumber = carPark.getPlateNumber();
            if (carPark.getDirection() == Direction.IN && meters.containsKey(plateNumber)) {
                distances.put(
                        plateNumber,
                        distances.getOrDefault(plateNumber, 0) + carPark.getCounter() - meters.get(plateNumber));
            }
            meters.put(plateNumber, carPark.getCounter());
        }
        return distances;
    }

    private void excercrise6() {
        System.out.println("\n6. feladat");

        Optional<Map.Entry<Integer, Integer>> longest = getLongestEmployee();

        if (longest.isEmpty()) {
            System.out.println("Senki nem ment sehova.");
        } else {

            System.out.printf("\tLeghosszabb út: %d km, személy: %d.%n", longest.get().getValue(), longest.get().getKey());
        }
    }

    public Optional<Map.Entry<Integer, Integer>> getLongestEmployee() {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> meters = new HashMap<>();
        int employee;
        for (CarPark carPark : parks) {
            employee = carPark.getEmployeeId();
            if (carPark.getDirection() == Direction.IN && meters.containsKey(employee)) {
                distances.put(employee,
                        distances.getOrDefault(employee, 0) + carPark.getCounter() - meters.get(employee));
            }
            meters.put(employee, carPark.getCounter());
        }

        return distances
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
    }

    private void excercrise7() {
        System.out.println("\n7. feladat");

        System.out.print("\tKérem az autó rendszámát: ");
        String plateNumber = scanner.nextLine();

        saveJourneySheet(plateNumber.toUpperCase());

        System.out.println("\tA menetlevél elkészült.");
    }

    private void saveJourneySheet(String plateNumber) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("C:/Temp").resolve(plateNumber + "_menetlevel.txt"))) {
            writeData(plateNumber, writer);
        } catch (IOException e) {
            throw new IllegalStateException("Fájl írási hiba!", e);
        }
    }

    public void writeData(String plateNumber, BufferedWriter writer) throws IOException {
        for (CarPark carPark : parks) {
            if (carPark.getPlateNumber().equals(plateNumber) && carPark.getDirection() == Direction.OUT) {
                writer.write(String.format("%3d  %2d. %s  %5d - ",
                        carPark.getEmployeeId(),
                        carPark.getDay(),
                        carPark.getTime(),
                        carPark.getCounter()));
            }
            if (carPark.getPlateNumber().equals(plateNumber) && carPark.getDirection() == Direction.IN) {
                writer.write(String.format("%2d. %s  %5d%n",
                        carPark.getDay(),
                        carPark.getTime(),
                        carPark.getCounter()));

            }
        }
    }
}
