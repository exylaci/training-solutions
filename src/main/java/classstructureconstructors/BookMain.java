package classstructureconstructors;

public class BookMain {
    public static void main(String[] args) {
        Book book=new Book("Marék Veronika","Már tudok olvasni!");
        book.register("HU123-1");

        System.out.println(book.getAuthor() + ": " + book.getTitle() + " (" + book.getRegNumber() +")");
    }
}
