package week08.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistics {
    public static final String SEPARATOR = " ";

    private List<Country> countries = new ArrayList<>();

    public void importCountries(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(fileName))));

            countries.clear();
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                processOneLine(oneLine);
            }

        } catch (NullPointerException | IOException e) {
            throw new IllegalStateException("Can't read from file!", e);
        }
    }

    public Country maxPopulaton() {
        Country result = null;
        int max = -1;

        for (Country one : countries) {
            if (one.getPopulation() > max) {
                result = one;
                max = one.getPopulation();
            }
        }
        return result;
    }

    private void processOneLine(String oneLine) {
        String[] split = oneLine.split(SEPARATOR);
        if (split.length > 3) {
            countries.add(new Country(split[0], parse(split[1]), parse(split[2]), parse(split[3])));
        }
    }

    private int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Corrupt data file!", e);
        }
    }

    public List<Country> getCountries() {
        return List.copyOf(countries);
    }
}
//Adott a countries.txt állomány, melyet helyezz el a projekt gyökérkönyvtárába.
// A fájlban az adatok a következők:
// ország_neve
// népesség
// hány_színű_a_zászló
// szomszédos_országok_száma.
//
// Készíts a week08d02 csomagba egy
// CountryStatistics osztályt melyben van egy metódus, ami
//  az adatokat beolvassa egy listába.
//
//  A lista legyen az osztály privát attribútuma, és legyen hozzá
//  getter metódus, figyelj arra, hogy ezen keresztül ne lehessen megváltoztatni a listát. Készíts egy metódust
//
//  maxPopulaton() néven, ami a listából visszaadja a
//  legnagyobb népességű ország minden adatát. (edited)