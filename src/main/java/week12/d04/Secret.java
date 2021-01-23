package week12.d04;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Secret {
    public void decoder() {

        try (BufferedInputStream input = new BufferedInputStream(Files.newInputStream(
                Path.of("src/main/resources/week12/d04/secret.dat")))) {
            byte[] buffer = new byte[27];
            int size;
            while ((size = input.read(buffer)) > 0) {
                for (int i = 0; i < size; ++i) {
                    System.out.print((char) (buffer[i] + 10));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//Töltsd le a példa bináris állomány a
// https://github.com/Training360/strukturavalto-java-public/raw/master/examples/week12d04/src/main/resources/secret.dat
// címről! Ez bájtokat tartalmaz, egy szöveg van titkosítva benne. Olvasd be bájtonként, és mindegyik bájthoz adjál
// hozzá tízet! Ez valójában egy karakterkód, ezt alakítsd át `char` típusú értékké! Majd egymás után írd ki ezeket
// a konzolra! Ne használj közöttük sortörést!