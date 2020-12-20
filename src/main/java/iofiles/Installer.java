package iofiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Installer {
    private static final Path SOURCE = Path.of("src/main/resources/iofiles/install");
    private List<String> todo = new ArrayList<>();
    private Path toWhere;

    public void install(String destination) {
        toWhere = Path.of(destination);
        if (!Files.exists(toWhere) || !Files.isDirectory(toWhere)) {
            throw new IllegalArgumentException("The given directory doesn't exist");
        }

        importToDo();
        doTheInstallation();

        System.out.println("Installation is over.");
    }

    private void importToDo() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("install/install.txt")));

            todo.clear();
            String oneLine;

            while ((oneLine = reader.readLine()) != null) {
                todo.add(oneLine);
            }

        } catch (IOException e) {
            throw new IllegalStateException("Can't read from file.");
        }
    }

    private void doTheInstallation() {
        try {


            for (String one : todo) {
                if (isDirectory(one)) {
                    Files.createDirectories(toWhere.resolve(one));
                } else {
                    Files.copy(SOURCE.resolve(one), toWhere.resolve(one), StandardCopyOption.REPLACE_EXISTING);
                }
            }


        } catch (IOException e) {
            throw new IllegalStateException("Installation has been failed!", e);
        }
    }

    private boolean isDirectory(String one) {
        return one.charAt(one.length() - 1) == '/';
    }
}
//Készíts egy Installer osztályt, egyetlen install() metódussal,
// amely paraméterként a telepítési mappát kapja meg String-ként.
// A megadott mappán belülre másold át a classpathról az install mappában
// lévő fájlokat és mappákat az install mappából!
// Az install.txt fájlban a / jelre végződő sorok mappákat jelölnek,
// ezeket létre kell hoznod, mielőtt fájlokat másolnál bele.
// Az esetleges sikertelen telepítésből visszamaradt fájlokat mindig írd felül!
// Ha a paraméterül kapott mappa nem létezik vagy nem is mappa, dobj IllegalArgumentException kivételt!
