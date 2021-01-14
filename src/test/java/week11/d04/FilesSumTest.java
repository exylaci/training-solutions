package week11.d04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FilesSumTest {

    @TempDir
    Path tempDirectory;

    @Test
    void sumNumbersTest() throws IOException {
        Files.writeString(tempDirectory.resolve("number00.txt"), "34");
        Files.writeString(tempDirectory.resolve("number56.txt"), "54");
        Files.writeString(tempDirectory.resolve("number99.txt"), "13");

        FilesSum f = new FilesSum();
        assertEquals(101, f.sumNumbers(tempDirectory));
    }

    @Test
    void sumNumbersExtremeTest() throws IOException {
        Files.writeString(tempDirectory.resolve("number00.txt"), "");
        Files.writeString(tempDirectory.resolve("number56.txt"), "13.4");
        Files.writeString(tempDirectory.resolve("number55.txt"), "5");
        Files.writeString(tempDirectory.resolve("number99.txt"), "bb");

        FilesSum f = new FilesSum();
        assertEquals(5, f.sumNumbers(tempDirectory));
    }
}