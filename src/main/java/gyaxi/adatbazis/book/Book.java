package gyaxi.adatbazis.book;

public class Book {
    private final int id;
    private final String author;
    private final String title;
    private final double price;
    private final int publisherId;

    public Book(int id, String author, String title, double price, int publisherId) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.publisherId = publisherId;
    }

    public Book(String author, String title, double price, int publisherId) {
        id = 0;
        this.author = author;
        this.title = title;
        this.price = price;
        this.publisherId = publisherId;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getPublisherId() {
        return publisherId;
    }
}