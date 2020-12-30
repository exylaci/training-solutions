package genericsusage.withGenerics;

import genericsusage.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public Library(List<Book> books) {
        this.books = books;
    }

    public void addBooks(Book book) {
        books.add(book);
    }

    public Book getFirstBook() {
        if (books == null) throw new NullPointerException("There is no Library at all!");
        if (books.size() == 0) throw new IllegalArgumentException("There are no books in the library!");
        return books.get(0);
    }
}
//Implementálj egy könytárat, ahol könyveket tárolhatunk.
//
// Valósítsuk meg a getFirstBook() metódust generics használata nélkül, és generics használatával is.
//
// Hibakezelés
//    Ha a könyvtárat reprezentáló kollekció null, dobjon NullPointerException kivételt
//    Ha a könyvtárat reprezentáló kollekció üres, dobjon IllegalArgumentException kivételt