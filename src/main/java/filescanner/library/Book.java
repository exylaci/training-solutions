package filescanner.library;

public class Book {
    private String author;
    private String title;
    private String registrationNumber;
    private int yearOfIssue;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public Book(String author, String title, String registartionNumber, int yearOfIssue) {
        this.registrationNumber = registartionNumber;
        this.author = author;
        this.title = title;
        this.yearOfIssue = yearOfIssue;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }
}
//Egy könyvtár nyilvántartása a könyvek leltári számát, szerzőjét, címét és a kiadás évét tartalmazza.
// Készíts egy Book osztályt, mely konstruktorában megkapja ezeket az adatokat!
// Minden adata lekérdezhető, de egyik sem módosítható.