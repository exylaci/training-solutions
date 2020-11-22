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
    }
}
