package interfacedefaultmethods.print;

public interface Printable {
    public static String BLACK = "#000000";

    int getLength();

    String getPage(int index);

    default String getColor(int index) {
        return BLACK;
    }
}
