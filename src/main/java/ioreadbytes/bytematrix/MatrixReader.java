package ioreadbytes.bytematrix;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixReader {
    private List<byte[]> matrix = new ArrayList<>();

    public void createMatrix(String pathString) {
        Path path = Path.of("src/main/resources/bytematrix");
        try {
            if (Files.exists(path)) return;
            Files.createDirectories(path);
            OutputStream writer = new BufferedOutputStream(Files.newOutputStream(path.resolve(pathString)));
            for (int i = 0; i < 8974; ++i) {
                if (i % 1000 < 493) {
                    writer.write((int) (1.05 * Math.random()));
                } else {
                    writer.write((int) (1.05 * Math.random() + .95));
                }
            }
            writer.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write matrix file!");
        }
    }

    public void readBytesAndCreateMatrix(String pathString) {
        Path path = Path.of("src/main/resources/bytematrix").resolve(pathString);
        byte[] bytes = new byte[1000];
        int size;
        try {
            InputStream reader = new BufferedInputStream(Files.newInputStream(path));
            while ((size = reader.read(bytes)) > 0) {
                matrix.add(Arrays.copyOf(bytes, size));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read from this file!");
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int pieces = 0;
        for (int i = 0; i < 1000; ++i) {
            int counter = 0;
            for (byte[] one : matrix) {
                if (one.length > i && one[i] == 0) {
                    ++counter;
                }
            }
            if (counter > matrix.size() / 2) {
                ++pieces;
            }
        }
        return pieces;
    }

    public List<byte[]> getMyMatrix() {
        return new ArrayList<>(matrix);
    }
}
//Ebben a feladatban egy mátrix adatszerkezettel kell dolgoznod.
// Hozz létre egy listát, ami byte tömbök tárolására alkalmas!
// Tárold el ebben a listában a mátrix.dat állományból beolvasott, minden 1000 bájtot tartalmazó byte tömböt!
//
//Az állományban csak egyesek és nullák vannak.
// Írj egy metódust, ami visszaadja azon oszlopok számát, ahol több nulla, mint egyes van a mátrixban!