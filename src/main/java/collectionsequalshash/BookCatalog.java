package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        return findBook(books, new Book(title, author));
    }

    public Book findBook(List<Book> books, Book book) {
        int index = books.indexOf(book);
        if (index < 0) {
            return null;
        }
        return books.get(index);
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> localBooks = new HashSet<>();
        for (Book book : books) {
            localBooks.add(book);
        }
        return localBooks;
    }
}
//A Book osztály objektumait rakjuk bele List és Set kollekció típusokba.
// Vizsgáljuk meg, hogy mely tesztesetek futnak le sikeresen, és melyek nem
// a Book osztályban felülírt, vagy éppen kihagyott equals és hashCode metódusok esetén. Értelmezzük a tapasztaltakat!
//
//
//A BookCatalog osztályban a következő publikus metódusok találhatók (ezek persze a tesztesetekből is következnek):
//
//public Book findBookByTitleAuthor(List<Book> books, String title, String author)
//public Book findBook(List<Book> books, Book book)
//public Set<Book> addBooksToSet(Book[] books)
//
//Hibakezelés
//  Használjuk ki a kollekciók boolean contains(Object o) metódusát!
//  Ha a metódus nem találja a keresett objektumot, a visszatérési érték legyen null.
//
//Megvalósítás
//  A Book osztályban az equals(Object o) és hashCode() metódusok megírásával és kikommentelésével (összes kombináció!)
//  próbáljuk ki az egyes tesztesetek sikeres vagy sikertelen lefutását. Értelmezzük a tapasztaltakat!
//
//Tippek
//  Értelmezzük, hogy mi történik akkor, ha a List kollekcióba azonos állapotú objektumokat töltünk.
//  Mit kapunk vissza keresés esetén?