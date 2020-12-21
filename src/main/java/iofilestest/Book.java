package iofilestest;

public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        check(author);
        check(title);
        this.author = author;
        this.title = title;
    }

    private void check(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Parameter cannot be empty!");
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        return 31 * author.hashCode() + title.hashCode();
    }
}