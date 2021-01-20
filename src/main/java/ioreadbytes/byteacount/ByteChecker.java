package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {
    public static final char COUNTED = 'a';

    public int readBytesAndFindAs(String pathString) {
        byte[] puffer = new byte[100];
        int size;
        int counter = 0;

        Path path = Path.of("src/main/resources/byteacount").resolve(pathString);
        try {
            InputStream reader = new BufferedInputStream(Files.newInputStream(path));
            while ((size = reader.read(puffer)) > 0) {
                for (int i = 0; i < size; ++i) {
                    if (puffer[i] == COUNTED) {
                        ++counter;
                    }
                }
            }
            return counter;
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read this file!", e);
        }
    }
}
//Adott a data.dat állomány melyben rengeteg karakter található.
// A feladatod, hogy számold meg benne az "a" betűket, a videóban látott eszközök segítségével.