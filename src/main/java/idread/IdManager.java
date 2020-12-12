package idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    private List<String> ids = new ArrayList<>();

    public void readIdsFromFile(String path) {
        path = "src/main/resources/" + path;
        try {
            BufferedReader reader = Files.newBufferedReader(Path.of(path), StandardCharsets.UTF_8);
            String oneLine;
            while ((oneLine = reader.readLine()) != null) {
                ids.add(oneLine);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read this file!");
        }
    }

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }
}
//Személyi igazolvány számok
//
//A idread csomagban készítsd el az IdManager osztályt.
// Ez az osztály felelős az
// idnumbers.txt (kitalált) személyi igazolvány számokat tartalmazó szöveges állomány feldolgozásáért.
// A readIdsFromFile() metódus megkap egy fájlnevet, és annak sorait tárolja el az
// List<String> ids listában.