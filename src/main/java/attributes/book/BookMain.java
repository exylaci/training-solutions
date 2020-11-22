package attributes.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Robbie");
        System.out.println(book.getTitle());

        book.setTitle("Kavics az égen");
        System.out.println(book.getTitle());
    }
}
