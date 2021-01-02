package sorting;

public class Book implements Comparable {
    private int id;
    private String author;
    private String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title.trim();
        this.author = author.trim();
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
        if (this == null || o == null || this.getClass() != o.getClass()) return false;
        return this.id == ((Book) o).getId();
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}