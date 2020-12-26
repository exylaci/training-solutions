package week09.d02;

public class FibCalculator {

    public static long sumEvents(int bound) {
        long sum = 0;
        int one = 0;
        int two = 1;

        while (two <= bound) {
            sum += two % 2 == 0 ? two : 0;
            int next = two + one;
            one = two;
            two = next;
        }
        return sum;
    }
}
//készíts egy osztályt FibCalculator néven. Ennek legyen egy metódusa long
//  sumEvens(int bound) néven.
// Ennek a metódusnak a feladata az, hogy összeadja a páros fibonacci számokat addig, amig a következő fibonacci szám
// nem nagyobb, mint bound, majd visszadja a végredményt.