package collectionsclass;

import java.util.Objects;

public class Book implements Comparable {
    private int id;
    private String author;
    private String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", id, author, title);
    }

    @Override
    public int compareTo(Object o) {
        return id - ((Book) o).getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == ((Book) o).getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
//Book osztály int id String title és String author attribútumokkal.
//
//A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el.
// Alapértelmezetten id alapján rendezi a Book objektumokat és az equals() metódus is ezen az attribútumon alapul.