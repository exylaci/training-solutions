package primitivetypes;

public class PrimitiveTypes {
    private final int BITS = 32;

    String toBinaryString(int n){
        String binaryRevers = "";
        for ( int i=0 ; i<BITS ; ++i){
            binaryRevers += n%2;
            n/=2;
        }

        String binary = "";
        for (int i=BITS ; i>0 ; --i) {
            binary += binaryRevers.charAt(i-1);
        }

        return binary;
    }

    String toBinaryString2(int n){
        StringBuilder binary = new StringBuilder();
        for ( int i=0 ; i<BITS ; ++i){
            binary.insert(0,n%2);
            n/=2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        PrimitiveTypes p = new PrimitiveTypes();
        System.out.println(p.toBinaryString(65));
        System.out.println(p.toBinaryString2(65));
        System.out.println(Integer.toBinaryString(65));

        System.out.println(new Integer(1) + new Integer(2));
        // Az 1 int literált betett Integerbe, majd azt autoboxingolta egy int-be.
        // Az 2 int literált betett Integerbe, majd azt autoboxingolta egy másik int-be.
        // a két int-et összeadja. Az eredmény = 3.
        // A 3-mat autoboxingolja Integerbe, amivel meghívja az Integer osztály toString metódusát.
        // A toString által visszaadott szöveget jeleníti meg print metódus.
    }
}
