package week13.d03;

import iofilestest.Library;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {

    @Test
    void getThePostActiveAuthorForCiklusTest() {
        List<Book> temp = List.of(new Book("iro1","",5),
                new Book("iro2","",5),
                new Book("iro2","",5),
                new Book("iro2","",5),
                new Book("iro3","",5)

                );
        Books b = new Books(temp);

        assertEquals("iro2",b.getThePostActiveAuthorForCiklus());
        assertEquals("iro2",b.getThePostActiveAuthorStream());
    }
}