package iowritebytes;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StringToBytes {

    public static final char STARTER_CHARACTER = '_';

    public void writeAsBytes(List<String> texts, Path path) {
        try {
            OutputStream writer = new BufferedOutputStream(Files.newOutputStream(path));
            for (String one : texts) {
                if (one != null && (one.length() == 0 || one.length() > 0 && one.charAt(0) != STARTER_CHARACTER)) {
                    writer.write(one.getBytes(StandardCharsets.UTF_8));
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//Hozz létre egy StringToBytes osztályt és készíts benne egy writeAsBytes() metódust!
// A metódus a paraméterként kapott szöveg listából az
// "_" jellel kezdődő szövegeken kívül minden mást kiír a szintén paraméterül kapott path-ra bináris fájlba.