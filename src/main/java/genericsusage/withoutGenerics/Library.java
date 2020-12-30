package genericsusage.withoutGenerics;

import genericsusage.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List books;

    public Library() {
        this.books = new ArrayList();
    }

    public Library(List books) {
        this.books = books;
    }

    public void addBooks(Object o) {
        if (o instanceof Book) {
            books.add((Book) o);
        } else {
            throw new IllegalArgumentException("This is not a Book!");
        }
    }

    public Book getFirstBook() {
        if (books == null) throw new NullPointerException("There is no Library at all!");
        if (books.size() == 0) throw new IllegalArgumentException("There are no books in the library!");
        Object o = books.get(0);
        if (o instanceof Book) {
            return (Book) books.get(0);
        } else {
            throw new IllegalStateException("The first element is not a Book!");
        }
    }
}
//Implementálj egy könytárat, ahol könyveket tárolhatunk.
//
// Valósítsuk meg a getFirstBook() metódust generics használata nélkül, és generics használatával is.
//
// Hibakezelés
//    Ha a könyvtárat reprezentáló kollekció null, dobjon NullPointerException kivételt
//    Ha a könyvtárat reprezentáló kollekció üres, dobjon IllegalArgumentException kivételt