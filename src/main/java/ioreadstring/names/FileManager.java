package ioreadstring.names;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager  {
    private Path path;
    private List<Human> names = new ArrayList<>();

    public FileManager(String path) {
        this.path = Path.of(path);
    }

    public void readFromFile(){
        try {
            List<String> lines= Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String one : lines) {
                names.add(new Human(one));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read from file!");
        }
    }

    public Path getMyFile() {
        return path;
    }

    public List<Human> getHumans() {
        return names;
    }
}
//A FileManager osztály felelős a fájl feldolgozásért.
// Egy Path típusú attribútumon keresztül érjük el a fájlt, míg a
// readFromFile() metódus felelős a beolvasásért és a
// Human objektumok létrehozásáért.