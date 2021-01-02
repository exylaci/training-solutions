package collectionsclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionManager {
    private List<Book> library;

    public CollectionManager(List<Book> library) {
        if (library == null) throw new IllegalArgumentException("Librari is a must!");
        this.library = library;
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }

    public List<Book> reverseLibrary() {
        List<Book> result = new ArrayList<>(library);
        Collections.reverse(result);
        return result;
    }

    public Book getFirstBook() {

        return Collections.min(library);
    }

    public Book getLastBook() {
        return Collections.max(library);
    }
}
//Készítsünk olyan osztályt, ami a Collections osztály kiválasztott metódusai segítségével
//"könyvtári szolgáltatásokat" nyújt.
//
//Megvalósítás
// Book osztály int id String title és String author attribútumokkal.
// A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el.
// Alapértelmezetten id alapján rendezi a Book objektumokat és az equals() metódus is ezen az attribútumon alapul.
//
//CollectionManager osztály private List<Book> library attribútummal. Ezt konstruktorból tudjuk feltölteni.
//
//publikus metódusok:
//  public CollectionManager(List<Book> library)
//  public List<Book> createUnmodifiableLibrary() //módosíthatatlan listát eredményez
//  public List<Book> reverseLibrary() //az eredeti lista másolatán dolgozik!
//  public Book getFirstBook() //a legrégebbi (legkisebb id) könyvet adja vissza
//  public Book getLastBook() // a legújabb (legnagyobb id) könyvet adja vissza