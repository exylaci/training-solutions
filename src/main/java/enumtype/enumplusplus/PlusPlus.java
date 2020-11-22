package enumtype.enumplusplus;

import java.util.Arrays;

public class PlusPlus {
    public static void main(String[] args) {

        Sequence s = Sequence.HATODIK;
        Sequence next = Sequence.values()[ (s.ordinal()+1) % Sequence.values().length ];

        System.out.println( Arrays.deepToString( Sequence.values() ));
        System.out.println(s + "+1="+next);

        System.out.println( Integer.toBinaryString(Integer.MIN_VALUE +1));
        System.out.println( Integer.toBinaryString(Integer.MIN_VALUE +1 >> 3 ));
        System.out.println( Integer.toBinaryString(Integer.MIN_VALUE +1 >>> 3 ));
    }
}
