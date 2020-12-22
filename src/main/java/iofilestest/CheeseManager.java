package iofilestest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeses) {
        if (path == null || cheeses == null) throw new IllegalArgumentException("Parameter cannot be null!");
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            for (Cheese one : cheeses) {
                out.writeUTF(one.getName());
                out.writeDouble(one.getLaktacitLevel());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write to file!", e);
        }
    }

    public Cheese findCheese(Path path, String name) {
        if (path == null || name == null) throw new IllegalArgumentException("Parameter cannot be null!");
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            while (in.available() > 0) {
                String oneName = in.readUTF();
                double level=in.readDouble();
                if (name.equals(oneName)) {
                    return new Cheese(oneName,level);
                }
            }
            return null;

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file!", e);
        }
    }
}
//Készíts egy immutable Cheese osztályt,
// amely a sajt nevét (String) és
// laktóztartalmát (double) tartalmazza.
//
//A CheeseManager osztályba készíts egy olyan
// saveToFile() metódust, amely a
//  paraméterül kapott Path által reprezentált bináris fájlba menti a szintén
//  paraméterül kapott Cheese lista tartalmát.
// A findCheese() metódusa a
//  Path-ként kapott fájlban megkeresi név alapján a sajtot, és
//  találat esetén egy Cheese objektumként adja vissza.
//
//Készíts az elkészült CheeseManager osztály metódusaihoz teszteket!