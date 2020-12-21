package iofilestest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @TempDir
    Path tempDirectory;

    @Test
    void addTest() {
        Book one = new Book("Author 1", "Title 1");
        Book two = new Book("Author 2", "Title 2");
        Book three = new Book("Author 3", "Title 3");

        Library l = new Library();
        l.add(one);
        l.add(two);
        l.add(three);
        l.add(new Book("Author 3", "Title 3"));
        assertEquals(3, l.getBooks().size());
    }

    @Test
    void saveTest() throws IOException {
        Book one = new Book("Author 1", "Title 1");
        Book two = new Book("Author 2", "Title 2");
        Book three = new Book("Author 3", "Title 3");
        Library l = new Library();
        l.add(one);
        l.add(two);
        l.add(three);

        Path path = tempDirectory.resolve("file.name");
        l.saveBooks(path);
        assertTrue(Files.exists(path));

        DataInputStream input = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)));
        assertEquals("Author 1", input.readUTF());
        assertEquals("Title 1", input.readUTF());
    }

    @Test
    void loadTest() throws IOException {
        Path path = tempDirectory.resolve("file.name");
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)));
        output.writeUTF("Author 1");
        output.writeUTF("Title 1");
        output.writeUTF("Author 2");
        output.writeUTF("Title 2");
        output.writeUTF("Author 3");
        output.writeUTF("Title 3");
        output.writeUTF("Author 3");
        output.writeUTF("Title 3");
        output.close();

        Library l = new Library();
        l.loadBooks(path);
        assertEquals(3, l.getBooks().size());
        assertEquals("Author 2", l.getBooks().get(1).getAuthor());
        assertEquals("Title 2", l.getBooks().get(1).getTitle());
    }

    @Test
    void loadCorruptFileTest() throws IOException {
        Path path = tempDirectory.resolve("file.name");
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)));
        output.writeUTF("Author 1");
        output.writeUTF("Title 1");
        output.writeUTF("");
        output.writeUTF("Title 1");
        output.close();

        Library l = new Library();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                l.loadBooks(path));
        assertEquals("Parameter cannot be empty!", exception.getMessage());
    }

    @Test
    void loadInvalidFileNameTest() throws IOException {
        Path path = tempDirectory.resolve("file.name");
        Library l = new Library();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> l.loadBooks(null));
        assertEquals("Path is a must!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> l.loadBooks(path));
        assertEquals("File doesn't exist!", exception.getMessage());
    }
}