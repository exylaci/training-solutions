package operators;

public class OperatorsMain {
    public static void main(String[] args) {

        Operators o = new Operators();
        System.out.println(o.isEven(3));
        System.out.println(o.isEven(4));

        int i = 16;
        System.out.println( i << 1);
        System.out.println( i >> 1);
        i = 13;
        System.out.println( i << 1);
        System.out.println( i >> 1);

        System.out.println(o.multiplyByPowerOfTwo(5,3));  //5*2^3


        i = -1;
        String s = Integer.toBinaryString(i);   // kettes komplemenst csinl
        System.out.println(s);
//        int j = Integer.parseInt(s, 2);       // "nem tudja", hogy ez egy kettes komplemensben ábrázolt negatív szám,
                                                // Így viszont nem fér bele egy (signed) int-be.
        long j = Long.valueOf(s, 2);       // long-ba már belefér
        System.out.println(j);
        System.out.println((int)j);             // típus konverzió során a csonkolás után
                                                // a legemagasabb helyiértéken lévő 1-es miat újra negatív számnak látja


        System.out.println(0333);               // oct 333 = dec 219
    }
}
