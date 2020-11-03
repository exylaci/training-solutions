package statements;

public class Befektetések {
    public static void main(String[] args) {
        String szoveg1 = new String("hello");
        String szoveg2 = new String("hello");
        System.out.println(szoveg1 == szoveg2);
        System.out.println(szoveg1.equals(szoveg2));
    }
}
