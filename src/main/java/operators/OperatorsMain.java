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
    }
}
