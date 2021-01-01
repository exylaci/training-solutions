package collectionsiterator;

import java.util.*;

public class LibraryManager {
    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        if (libraryBooks == null || libraryBooks.isEmpty()) throw new IllegalArgumentException("Book list is a must!");

        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        for (Iterator<Book> iterator = libraryBooks.iterator(); iterator.hasNext(); ) {
            Book one = iterator.next();
            if (one.getRegNumber() == regNumber) {
                return one;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
//        libraryBooks.remove(findBookByRegNumber(regNumber));
        for (Iterator<Book> iterator = libraryBooks.iterator(); iterator.hasNext(); ) {
            Book one = iterator.next();
            if (one.getRegNumber() == regNumber) {
                iterator.remove();
                return regNumber;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> result = new HashSet<>();
        for (Iterator<Book> iterator = libraryBooks.iterator(); iterator.hasNext(); ) {
            Book one = iterator.next();
            if (one.getAuthor().equals(author)) {
                result.add(one);
            }
        }
        if (result.size() == 0){
            throw new MissingBookException("No books found by " + author);
        }
        return result;
    }

    public int libraryBooksCount() {
        return libraryBooks.size();
    }
}
//Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek szoftveres menedzselését valósítja meg.
//A könyvtárat feltöltjük egyedi könyvekkel, és egyedi regisztrációs szám alapján kikereshetjük, eltávolíthatjuk
//a könyvtár állományából, illetve szerző szerint kigyűjthetünk könyveket.
//
//Megvalósítás
//Book osztály int regNumber String title és String author attribútumokkal.
//Az equals() és hashCode() metódusokat az igényeknek megfelelően készítsük el, egyedi a regNumber attribútum.
//LibraryManager osztály Set<Book> libraryBooks attribútummal. Ezt konstruktorból tudjuk feltölteni.
//
//publikus metódusok:
// public Book findBookByRegNumber(int regNumber)
// public int removeBookByRegNumber(int regNumber)
// public Set<Book> selectBooksByAuthor(String author)
//
//Mindhárom metódus saját MissingBookException-t (RuntimeException) dob,
// ha a regisztrációs számnak megfelelő könyv nem található, vagy adott szerzővel nem található könyv.
//
//Tipp
// Használjunk iterátoros bejárást a könyvek megtalálására és kigyűjtésére.
// A tesztelés segítésére készítsünk egy public int libraryBooksCount() metódust is,
//  ami visszaadja a Book kollekció méretét.