package collectionscomp;

public class Book implements Comparable {
    private int regNumber;
    private String title;
    private String author;

    public Book(int registrationNumber, String title, String author) {
        this.regNumber = registrationNumber;
        this.title = title;
        this.author = author;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Object o) {
//        return this.author.compareTo(((Book) o).getAuthor());
        return this.regNumber - (((Book) o).regNumber);
    }
}
//Book osztály int regNumber String title és String author attribútumokkal.
//
//A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el.