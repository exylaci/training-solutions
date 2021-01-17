package lambdastreams.bookstore;

public class Book {
    private String title;
    private int year;
    private int price;
    private int pieces;

    public Book(String title, int year, int price, int pieces) {
        this.title = title;
        this.year = year;
        this.price = price;
        this.pieces = pieces;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }
}
//Készíts egy Book osztályt a könyv címével, kiadási évével, árával, darabszámával!
//A konstruktor is ebben a sorrendben kapja meg az adatokat.