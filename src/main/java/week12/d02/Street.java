package week12.d02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class Street {
    public static final String SEPARATOR = " ";
    public static final int MAX_LENGTH = 1000;
    private List<Parcel> odds = new ArrayList<>();
    private List<Parcel> evens = new ArrayList<>();

    private int getLength(List<Parcel> parcels) {
        return parcels.stream()
                .mapToInt(Parcel::getLength)
                .sum();
    }

    public List<Parcel> getSide(String side) {           //csak a tesztelés miatt publikus
        switch (side) {
            case "0":
                return evens;
            case "1":
                return odds;
        }
        return Collections.emptyList();
    }

    public void addParcel(String parcel) {
        if (parcel == null) throw new IllegalArgumentException("Parcel is a must!");

        String[] parts = parcel.split(SEPARATOR);
        List<Parcel> side = getSide(parts[0]);
        if (Integer.parseInt(parts[1]) + getLength(side) > MAX_LENGTH) {
            throw new IllegalArgumentException("This exceeds the max length of the street!");
        }
        side.add(new Parcel(getNext(side, parts[0]), Integer.parseInt(parts[1]), parts[2]));
    }

    private int getNext(List<Parcel> parcels, String side) {
        OptionalInt op = parcels.stream().mapToInt(Parcel::getNumero).max();
        if (op.isPresent()) {
            return op.getAsInt() + 2;
        }
        if (side.equals("0")) {
            return 2;
        } else {
            return 1;
        }
    }

    public void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("kerites.txt")))) {
            odds.clear();
            evens.clear();

            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                addParcel(oneLine);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read from kerites.txt file!");
        }
    }

    public List<Parcel> getParcelsBySize() {
        List<Parcel> temp = new ArrayList<>(odds);
        temp.addAll(evens);

        return temp
                .stream()
                .sorted(Comparator.comparingInt(Parcel::getLength).thenComparingInt(Parcel::getNumero))
                .collect(Collectors.toList());
    }

    public void writeToFileOdds(Path path) {
        if (path == null) throw new IllegalArgumentException("Path is a must!");

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE)) {
            for (Parcel parcel : odds) {
                writer.write(parcel.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write into file: " + path);
        }
    }
}
//A kerites.txt fájlban egy utca telek nyilvántartását találjuk. Minden sorban három adat található.
// Az első szám megadja, hogy a telek a páros (0) vagy a páratlan (1) oldalán van az utcának;
// a második a telek szélességét adja meg méterben (egész szám, értéke 8 és 20 között lehet);
// a harmadik pedig az utcafronti kerítés színét leíró karakter. A szín az angol ábécé nagybetűje.
// Ha a kerítést már elkészítették, de nem festették be, akkor a „#” karakter,
// ha még nem készült el, akkor a „:” (kettőspont) karakter szerepel.
//
// Az utca hossza legfeljebb 1000 méter.
// Mindkét oldalon elkelt legalább 3-3 telek.
// Amikor vásárolunk mindig csak az utojára eladott telek rákövetkezőjét vehetjük,
// vagy a másik oldalon utoljára eladott rákövetkezőjét.
//
//Példa:
//0 10 P
//1 8 K
//1 10 :
//1 9 S
//0 10 P
//
//Magyarázat: Az első telek a páros oldalon található, 10 méter széles, a kerítés kész és P színnel festették be.
//A harmadik telek a páratlan oldalon van szintén 10 méter, a kerítés kész, de még nincs befestve.
//A házszámok a következők sorban: 2,1,3,5,4
//
//Feladatok:
//  Olvasd be a fájl tartalmát a memóriába!
//  Az eddig eladott telkekből készítsünk egy sorrendet, méghozzá a méretük alapján!
//  Határozzuk meg a fájl utolsó sorában szereplő telek házszámát!
//  Írd ki egy fájlba, a páratlan oldal utcaképét!
//      Pl.: (1)KKKKKKKK(3)::::::::::(5)SSSSSSSSS
//      Magyarázat: A házszám zárójelben, majd annyi a kerítést leíró jellemző, amilyen hosszú a telek.