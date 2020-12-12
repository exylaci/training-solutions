package music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    public static final String SEPARATOR = ";";

    private List<Band> bands = new ArrayList<>();

    public void readBandsFromFile(Path path) {
        bands.clear();
        try {
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                bands.add(convertToBand(oneLine));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read this file!");
        }

    }

    private Band convertToBand(String oneLine) {
        int year = 0;
        String[] split = oneLine.split(SEPARATOR);
        if (split.length > 1) {
            year = parse(split[1]);
        }
        return new Band(split[0], year);
    }

    private int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void writeBandsBefore(Path path, int year) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            for (Band one : bands) {
                if (one.getYear() < year) {
                    writer.write(one.toString());
                    writer.newLine();
                }
            }
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write this file");
        }
    }
}
//Ebben a fájl olvasását és írását is gyakorolhatod.
// Adott a bands_and_years.txt állomány, melyben zenekarok nevét és alapítási évét találod.
// Készíts egy metódust melynek a paramétere egy fájl és egy évszám!
// Ez a metódus ki fogja írni a fájlba az évszámnál régebben alakult zenekarokat.
// Megoldási javaslat, hogy készíts egy privát metódust, ami kigyűjti ezeket a zenekarokat egy listába.
// Minden zenekart egy Band objektum reprezentál, melynek attribútumai a név és az évszám.