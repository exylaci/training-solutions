package week13.d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookStoreTest {

    List<Book> temp = List.of(new Book("iro1", "", 5),
            new Book("iro2", "", 5),
            new Book(null, "", 0),
            new Book("iro2", "", 5),
            new Book("iro2", "", 5),
            new Book(null, "", 0),
            new Book("iro3", "", 5));

    @Test
    void getThePostActiveAuthorStreamTest() {
        assertEquals("iro2", new BookStore().getThePostActiveAuthorStream(temp));
    }

    @Test
    void getThePostActiveAuthorForTest() {
        assertEquals("iro2", new BookStore().getThePostActiveAuthorForCiklus(temp));
    }
}