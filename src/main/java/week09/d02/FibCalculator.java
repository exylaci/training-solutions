package week09.d02;

public class FibCalculator {

    public static long sumEvents(int bound) {
        int sum = 0;
        int one = 0;
        int two = 1;

        while (two < bound) {
            sum += two % 2 == 0 ? two : 0;
            int next = two + one;
            one = two;
            two = next;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumEvents(100));
    }
}