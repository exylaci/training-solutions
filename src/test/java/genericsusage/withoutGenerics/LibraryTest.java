package genericsusage.withoutGenerics;

import genericsusage.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LibraryTest {
    @Test
    public void testGenericsUsageWithoutGenerics() {
        Library library = new Library();

        library.addBooks(new Book("író", "cím"));

        assertEquals("író", library.getFirstBook().getAuthor());
        assertEquals("cím", library.getFirstBook().getTitle());
    }

    @Test
    public void testGenericsUsageWithoutGenericsDifferentObjectAdd() {
        Library library = new Library();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                library.addBooks("író"));
        assertEquals("This is not a Book!", exception.getMessage());
    }

    @Test
    public void testGenericsUsageWithoutGenericsDifferentObjectInTheList() {
        List<Object> temp = List.of("szöveg");
        Library library = new Library(temp);

        Exception exception = assertThrows(IllegalStateException.class, () ->
                library.getFirstBook());
        assertEquals("The first element is not a Book!", exception.getMessage());
    }

    @Test
    public void testGenericsUsageWithoutGenericsEmptyList() {
        Library library = new Library();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                library.getFirstBook());
        assertEquals("There are no books in the library!", exception.getMessage());
    }

    @Test
    public void testGenericsUsageWithoutGenericsNoList() {
        Library library = new Library(null);

        Exception exception = assertThrows(NullPointerException.class, () ->
                library.getFirstBook());
        assertEquals("There is no Library at all!", exception.getMessage());
    }
}