package typeconversion.whichtype;

import java.util.List;

public class WhichTypeMain {
    public static void main(String[] args) {

    Type.BYTE.setMax(Byte.MAX_VALUE);
    Type.BYTE.setMin(Byte.MIN_VALUE);
    Type.SHORT.setMax(Short.MAX_VALUE);
    Type.SHORT.setMin(Short.MIN_VALUE);
    Type.INT.setMax(Integer.MAX_VALUE);
    Type.INT.setMin(Integer.MIN_VALUE);

    System.out.println(Type.BYTE.getMax());
    System.out.println(Type.BYTE.getMin());
    System.out.println(Type.SHORT.getMax());
    System.out.println(Type.SHORT.getMin());
    System.out.println(Type.INT.getMax());
    System.out.println(Type.INT.getMin());
    System.out.println();


    WhichType t = new WhichType();
        System.out.println(t.whichType( Long.toBinaryString( 127) ));           //byte
        System.out.println(t.whichType( "-" + Long.toBinaryString( 128) ));
        System.out.println(t.whichType( Long.toBinaryString( 128) ));
        System.out.println(t.whichType( "-" + Long.toBinaryString( 129) ));
        System.out.println();

        System.out.println(t.whichType( Long.toBinaryString( 32767) ));           //short
        System.out.println(t.whichType( "-" + Long.toBinaryString( 32768) ));
        System.out.println(t.whichType( Long.toBinaryString( 32768) ));
        System.out.println(t.whichType( "-" + Long.toBinaryString( 32769) ));
        System.out.println();

        System.out.println(t.whichType( Long.toBinaryString( 2147483647L) ));           //int
        System.out.println(t.whichType( "-" + Long.toBinaryString( 2147483648L) ));
        System.out.println(t.whichType( Long.toBinaryString( 2147483648L) ));
        System.out.println(t.whichType( "-" + Long.toBinaryString( 2147483649L) ));
        System.out.println();
    }
}
