package week07d05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveInputTest {

    final String FILENAME = "testfile.txt";

    @TempDir
    Path tempDirectory;

    @Test
    void askFilenameTest() {
        Scanner scanner = new Scanner(FILENAME);
        SaveInput s = new SaveInput();
        assertEquals(Path.of(FILENAME), s.askFileNamne(scanner).getFileName());
    }

    @Test
    void askLinesTest() {
        Scanner scanner = new Scanner("1.sor\n2.sor\n3.sor");
        SaveInput s = new SaveInput();
        assertEquals(List.of("1.sor", "2.sor", "3.sor"), s.askLines(scanner));
    }

    @Test
    void writeLinesToFileTest() throws IOException {
        Path path = tempDirectory.resolve("testfile.txt");
        List<String> lines = List.of("1.sor", "2.sor", "3.sor");

        SaveInput s = new SaveInput();
        s.writeLinesToFile(path, lines);

        String result = Files.readString(path);
        assertEquals("1.sor\r\n2.sor\r\n3.sor\r\n", result);
    }

    @Test
    void writeToFileTest() throws IOException {
        Scanner scanner = new Scanner("1.sor\n2.sor\n3.sor\n" + FILENAME);


        SaveInput s = new SaveInput();
        s.writeToFile(scanner);

        Path path = Path.of(FILENAME);
        String result = Files.readString(path);

        assertEquals("1.sor\r\n2.sor\r\n3.sor\r\n", result);
    }
}