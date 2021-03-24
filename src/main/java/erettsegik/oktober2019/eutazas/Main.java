package erettsegik.oktober2019.eutazas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private List<Trip> trips = new ArrayList<>();

    public static void main(String[] args) {
        Main eUtazas = new Main(new ArrayList<>());
        try {
            eUtazas.excercrise1("utasadat.txt");
            eUtazas.excercrise2();
            eUtazas.excercrise3();
            eUtazas.excercrise4();
            eUtazas.excercrise5();
            eUtazas.excercrise7(Path.of("C:/temp"));
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
    }

    //teszteléshez
    public Main(List<Trip> trips) {
        this.trips = trips;
    }

    //teszteléshez
    public List<Trip> getTrips() {
        return Collections.unmodifiableList(trips);
    }

    public void excercrise1(String fileName) throws IllegalStateException {
        System.out.println("\n1. feladat");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName)))) {

            String oneLine;
            while (((oneLine = reader.readLine()) != null)) {
                trips.add(new Trip(oneLine));
            }
            System.out.println("\tSikeres adatbeolvasás.");

        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Nem olvasható a file!");
        }
    }

    public void excercrise2() {
        System.out.println("\n2. feladat");

        System.out.printf("\tA buszra %d utas akart felszállni.%n", trips.size());
    }

    public void excercrise3() {
        System.out.println("\n3. feladat");

        System.out.printf("\tA buszra %d utas nem szállhatott fel.%n",
                trips.stream()
                        .filter(Trip::notValid)
                        .count());
    }

    public void excercrise4() {
        System.out.println("\n4. feladat");

        Map.Entry<Integer, Long> result = trips
                .stream()
                .collect(Collectors.groupingBy(Trip::getStop, Collectors.counting()))
                .entrySet()
                .stream()
                .max(sortPaasangerNumber)
                .orElseThrow(() -> new IllegalStateException("Nem volt egyetlen utas sem."));

        System.out.printf("\tA legtöbb utas (%d fő) a %d. megállóban próbált felszállni.%n",
                result.getValue(), result.getKey());
    }

    private final Comparator<Map.Entry<Integer, Long>> sortPaasangerNumber = (a, b) -> (int) (a.getValue() == b.getValue() ?
            b.getKey() - a.getKey() : (a.getValue() - b.getValue()));

    public void excercrise5() {
        System.out.println("\n5. feladat");

        int free = 0;
        int reduced = 0;
        for (Trip trip : trips) {
            switch (trip.getType().getDiscount()) {
                case FREE -> ++free;
                case REDUCEDPRICE -> ++reduced;
            }
        }

        System.out.printf("\tIngyenesen utazók száma: %d fő%n", free);
        System.out.printf("\tA kedvezményesen utazók száma: %d fő%n", reduced);
    }

    //6. feladat
    public int napokszama(int e1, int h1, int n1, int e2, int h2, int n2) {
        h1 = (h1 + 9) % 12;
        e1 = e1 - h1 / 10;
        int d1 = 365 * e1 + e1 / 4 - e1 / 100 + e1 / 400 + (h1 * 306 + 5) / 10 + n1 - 1;
        h2 = (h2 + 9) % 12;
        e2 = e2 - h2 / 10;
        int d2 = 365 * e2 + e2 / 4 - e2 / 100 + e2 / 400 + (h2 * 306 + 5) / 10 + n2 - 1;
        return d2 - d1;
    }

    public void excercrise7(Path path) {
        System.out.println("\n7. feladat");

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(
                path.resolve("figyelmeztetes.txt"), StandardCharsets.UTF_8, StandardOpenOption.CREATE))) {

            for (Trip oneTrip : trips) {
                if (oneTrip.getType().isSeasonPass() &&
                        napokszama(oneTrip.getTimeStamp().getYear(), oneTrip.getTimeStamp().getMonthValue(), oneTrip.getTimeStamp().getDayOfMonth(),
                                oneTrip.getValid().getYear(), oneTrip.getValid().getMonthValue(), oneTrip.getValid().getDayOfMonth()) <= 3) {

                    writer.printf(new Locale("hu", "HU"), "%s %s",
                            oneTrip.getPassId(),
                            oneTrip.getValid().toString());
                    writer.println();
                }
            }
            System.out.println("\tA kiírt file: " + path.resolve("figyelmeztetes.txt").toString());
        } catch (IOException e) {
            throw new IllegalStateException("Nem lehet a fájlt írni: " + path.toString());
        }
    }
}
