package searching;

public class BookArraySearch {
    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        if (bookArray == null) throw new IllegalArgumentException("Book list is a must!");
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        check(author);
        check(title);
        Book findIt = new Book(0, author, title);
        for (Book one : bookArray) {
            if (findIt.equals(one)) {
                return one;
            }
        }
        throw new IllegalArgumentException("No book found by " + author + " with title " + title);
    }

    private void check(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("Author or title must not be empty!");
    }
}
//Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek között tud keresni adott szerzőre és címre.
//Az osztályban a könyveket objektum tömb formájában tároljuk, a keresés legyen bináris keresés.
//
//Megvalósítás
//  Book osztály int id String title és String author attribútumokkal.
//  A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el.
//  Alapértelmezetten szerző és ezen belül cím alapján rendezi a Book objektumokat.
//
//BookArraySearch osztály private Book[] bookArray attribútummal.
//  Ezt konstruktorból tudjuk feltölteni.
//
//publikus metódusok:
// public BookArraySearch(Book[] bookArray)
// public Book findBookByAuthorTitle(String author, String title)
//
//Kivételkezelés
//A két String paramétert le kell ellenőrizni, üres String esetén dobjon IllegalArgumentException-t.
//Ha a bináris keresés nem talál könyvet, dobjon IllegalArgumentException-t a megfelelő tájékoztató szöveggel.