package week07d05;

import java.nio.file.Path;
import java.util.List;

public class DataToFile {
    private List<String> lines;
    private Path filename;

    public DataToFile(Path filename, List<String> lines) {
        this.lines = lines;
        this.filename = filename;
    }

    public List<String> getLines() {
        return lines;
    }

    public Path getFilename() {
        return filename;
    }
}