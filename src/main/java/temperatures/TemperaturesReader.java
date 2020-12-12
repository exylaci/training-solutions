package temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String path) {
        try {
            return new Temperatures(
                    Files.readAllBytes(Path.of(path)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't read from this file!");
        }
    }
}