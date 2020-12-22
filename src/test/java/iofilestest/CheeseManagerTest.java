package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheeseManagerTest {
    @TempDir
    Path temporallyDirectory;

    @Test
    void saveToFileTest() {
        List<Cheese> cheeses = List.of(new Cheese("one", 1),
                new Cheese("two", 34.5),
                new Cheese("three", 45.6));

        Path path = temporallyDirectory.resolve("file.name");
        CheeseManager c = new CheeseManager();
        c.saveToFile(path, cheeses);

        assertTrue(Files.exists(path));
    }

    @Test
    void saveToFileParameterTest(){
        CheeseManager c = new CheeseManager();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                c.saveToFile(null, new ArrayList<Cheese>()));
        assertEquals("Parameter cannot be null!", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () ->
                c.saveToFile(Path.of(""), null));
        assertEquals("Parameter cannot be null!", exception.getMessage());
    }

    @Test
    void findCheeseTest() throws IOException {
        Path path = temporallyDirectory.resolve("file.name");
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)));
        out.writeUTF("one");
        out.writeDouble(34.6);
        out.writeUTF("two");
        out.writeDouble(56.1);
        out.writeUTF("three");
        out.writeDouble(99);
        out.close();

        CheeseManager c = new CheeseManager();
        Cheese cheese = c.findCheese(path, "two");
        assertEquals("two", cheese.getName());
        assertEquals(56.1, cheese.getLaktacitLevel(), 0.003);

        cheese = c.findCheese(path, "not exists");
        assertEquals(null, cheese);

        cheese = c.findCheese(path, "");
        assertEquals(null, cheese);
    }

    @Test
    void findParameterTest() {
        CheeseManager c = new CheeseManager();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                c.findCheese(null, "this"));
        assertEquals("Parameter cannot be null!", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () ->
                c.findCheese(Path.of(""), null));
        assertEquals("Parameter cannot be null!", exception.getMessage());
    }
}
