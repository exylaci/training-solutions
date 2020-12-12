package temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesWriter {
    public void writeTemperatures(Temperatures temperatures, String path) {
        try {
            Files.write(Path.of(path), temperatures.getData());
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't write to file!");
        }
    }
}