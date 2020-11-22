package objects;

public class ObjectsMain {
    public static void main(String[] args) {
        new Book();                             // lehet példányosítani, de nem lehet elérni

        Book book = new Book();
        System.out.println(book);

        Book emptyBook ;                        // kell neik értéket adni!
        emptyBook = null;
        System.out.println(emptyBook);

        System.out.println(emptyBook==null);

        emptyBook = new Book();
        System.out.println(emptyBook);

        Book anotherBook = new Book();
        System.out.println(book==anotherBook);

        book=anotherBook;
        System.out.println(book==anotherBook);

        System.out.println(anotherBook instanceof Book);


        Book book1 = new Book();        // 1 db
        Book book2 = new Book();        // 2 db
        Book book3 = new Book();        // 3 db
        Book book4 = book1;             // 3 db
        Book book5 = book1;             // 3 db
        Book book6 = book3;             // 3 db
        Book book7 = null;              // 3 db
        book4 = book5;                  // 3 db
        book5 = new Book();             // 4 db
        book6 = null;                   // 4 db
    }
}
