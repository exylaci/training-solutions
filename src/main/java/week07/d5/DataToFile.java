package week07.d5;

import java.util.List;

public class DataToFile {
    private List<String> lines;
    private String filename;

    public DataToFile(String filename, List<String> lines) {
        this.lines = lines;
        this.filename = filename;
    }

    public List<String> getLines() {
        return lines;
    }

    public String getFilename() {
        return filename;
    }
}
