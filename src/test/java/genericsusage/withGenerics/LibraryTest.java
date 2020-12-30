package genericsusage.withGenerics;

import genericsusage.Book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LibraryTest {
    @Test
    public void testGenericsUsageWithGenerics() {
        Library library = new Library();

        library.addBooks(new Book("író", "cím"));

        assertEquals("író", library.getFirstBook().getAuthor());
        assertEquals("cím", library.getFirstBook().getTitle());
    }

    @Test
    public void testGenericsUsageWithGenericsEmptyList() {
        Library library = new Library();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                library.getFirstBook());
        assertEquals("There are no books in the library!", exception.getMessage());
    }

    @Test
    public void testGenericsUsageWithGenericsNoList() {
        Library library = new Library(null);

        Exception exception = assertThrows(NullPointerException.class, () ->
                library.getFirstBook());
        assertEquals("There is no Library at all!", exception.getMessage());
    }
}