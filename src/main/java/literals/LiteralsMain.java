package literals;

public class LiteralsMain {
    public static void main(String[] args) {
        System.out.println("Összefűzés");
        System.out.println("" + 1 + 2);
        System.out.println(new Integer(1).toString() + new Integer(2).toString());
        System.out.println(((Integer)1).toString() + ((Integer)2).toString() );

        System.out.println("\nOsztás");
        double qutient1 = 3 / 4 ;
        double qutient2 = 3. / 4 ;
        System.out.println(qutient1 + " " + qutient2);

        System.out.println("\nNagy szám");
        long big = 3_244_444_444L;
        System.out.println(big);

        System.out.println("\nKarakterkódolás");
        String s = "árvíztűrőtükörfúrógép";
        System.out.println(s);

        System.out.println("\nString mint objektum");
        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println("\nSzám bináris stringként");
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));
    }
}
