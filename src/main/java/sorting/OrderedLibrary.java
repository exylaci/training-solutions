package sorting;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {
    private Set<Book> library;

    public OrderedLibrary(TreeSet<Book> library) {
        if (library == null) throw new NullPointerException("Library is a must!");
        this.library = library;
    }

    public Book lendFirstBook() {
        Iterator<Book> iterator = library.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        throw new NullPointerException("Libray is empty!");
    }
}
//Készítsünk olyan osztályt, ami a könyvtárban tárolt könyveket alapvetően rendezett formában tárolja.
//
//Megvalósítás
// Book osztály int id String title és String author attribútumokkal.
//  A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el. Alapértelmezett az id szerinti rendezés.
//
// OrderedLibrary osztály Set<Book> library attribútummal. Ezt konstruktorból tudjuk feltölteni.
//
//publikus metódusok:
// public OrderedLibrary(Set<Book> library)
// public Book lendFirstBook()
//  A rendezett kollekcióból adjuk ki az első könyv referenciáját "kölcsönzéshez"!
//
//Tipp
// Amennyiben a kollekció üres,
//  a lendFirstBook() metódus dobjon egy NullPointerException-t a megfelelő tájékoztató szöveggel.