package iofilestest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    void bookTest() {
        Book one = new Book("author", "title");
        Book two = new Book("author", "title");

        assertEquals("author", one.getAuthor());
        assertEquals("title", one.getTitle());
        assertTrue(one.equals(two));
    }

    @Test
    void contructorTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Book(null, "title"));
        assertEquals("Parameter cannot be empty!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Book(" ", "title"));
        assertEquals("Parameter cannot be empty!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Book("author", null));
        assertEquals("Parameter cannot be empty!", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () ->
                new Book("author", " "));
        assertEquals("Parameter cannot be empty!", exception.getMessage());

    }
}