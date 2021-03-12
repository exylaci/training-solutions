package erettsegik.majus2020.metjelentes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    List<Data> datas = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();

        try {
            main.feladat1();
            main.feladat2();
            main.feladat3();
            main.feladat4();
            main.feladat5();
            main.feladat6();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void feladat1() {
        System.out.println("\n1. feladat");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getResourceAsStream("tavirathu13.txt")))) {

            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                datas.add(new Data(oneLine));
            }
            System.out.println("\tMinden adat betöltöltve.");

        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Cannot read fromfiel!", e);
        }
    }

    private void feladat2() {
        System.out.println("\n2. feladat");

        String city = askCode();
        Optional<Data> last = findLast(city);

        if (last.isPresent()) {
            System.out.printf("\tAz utolsó mérési adat a megadott településről %s-kor érkezett.%n",
                    last.get().getTime().format(TIME_FORMATTER));
        } else {
            System.out.println("\tNincs adat!");
        }
    }

    private Optional<Data> findLast(String city) {
        return datas
                .stream()
                .filter(data -> data.getCity().equals(city))
                .reduce((one, next) -> next);
    }

    private String askCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\tKérek egy város kódot: ");
        return scanner.nextLine().toUpperCase();
    }

    private void feladat3() {
        System.out.println("\n3. feladat");

        int max = -1;
        int min = 100;
        Data minData = null;
        Data maxData = null;
        for (Data data : datas) {
            if (min > data.getTemperature()) {
                min = data.getTemperature();
                minData = data;
            }
            if (max < data.getTemperature()) {
                max = data.getTemperature();
                maxData = data;
            }
        }

        System.out.printf("\tA legmalacsonyabb hőmérséklet: %s %s %2d fok%n",
                minData.getCity(), minData.getTime().format(TIME_FORMATTER), minData.getTemperature());
        System.out.printf("\tA legmagasabb hőmérséklet: %s %s %2d fok%n",
                maxData.getCity(), maxData.getTime().format(TIME_FORMATTER), maxData.getTemperature());
    }

    private void feladat4() {
        System.out.println("\n4. feladat");

        boolean noWind = false;
        for (Data data : datas) {
            if (data.getWind().equals("00000")) {
                System.out.printf("\t%s %s%n", data.getCity(), data.getTime().format(TIME_FORMATTER));
                noWind = true;
            }
        }

        if (!noWind) {
            System.out.println("\tNem volt szélcsend a mérések idején.");
        }
    }

    private void feladat5() {
        System.out.println("\n5. feladat");

        Map<String, Temperatures> temperatures = new HashMap<>();

        for (Data data : datas) {
            if (!temperatures.containsKey(data.getCity())) {
                temperatures.put(data.getCity(), new Temperatures());
            }
            temperatures.put(data.getCity(),
                    temperatures.get(data.getCity()).store(data.getTemperature(), data.getTime().getHour()));
        }

        for (Map.Entry<String, Temperatures> one : temperatures.entrySet()) {
            if (one.getValue().isAverage()) {
                System.out.printf("\t%s Középhőmérséklet: %2d; Hőmérséklet-ingadozás: %d%n",
                        one.getKey(), one.getValue().getAverage(), one.getValue().getDifference());
            }
        }
        for (Map.Entry<String, Temperatures> one : temperatures.entrySet()) {
            if (!one.getValue().isAverage()) {
                System.out.printf("\t%s NA; Hőmérséklet-ingadozás: %d%n",
                        one.getKey(), one.getValue().getDifference());
            }
        }
    }


    private void feladat6() {
        System.out.println("\n6. feladat");

        Set<String> cities = datas
                .stream()
                .map(Data::getCity)
                .collect(Collectors.toSet());

        for (String city : cities) {
            try (BufferedWriter writer = Files.newBufferedWriter(Path.of("C:/temp/" + city + ".txt"), StandardOpenOption.CREATE)) {
                writer.write(city);
                writer.newLine();
                makeHistograms(writer, city);
            } catch (IOException e) {
                throw new IllegalStateException("Can't write file" + city, e);
            }
        }
        System.out.printf("\tA fájlok elkészültek.");
    }

    private void makeHistograms(BufferedWriter writer, String city) throws IOException {
        for (Data data : datas) {
            if (data.getCity().equals(city)) {
                writer.write(data.getTime().format(TIME_FORMATTER));
                writer.write(" ");
                writer.write(Stream
                        .generate(() -> "#")
                        .limit(data.getWindPower())
                        .collect(Collectors.joining()));
                writer.newLine();
            }
        }
    }
}