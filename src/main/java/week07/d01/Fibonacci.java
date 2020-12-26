package week07.d01;

public class Fibonacci {

    public static long fib(int index) {

        long beforeprevious = 1;
        long previous = 0;
        long result = 0;

        for (int i = 0; i < index; ++i) {
            try {
                result = Math.addExact(beforeprevious, previous);
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("Túl sokadik elemet kéred. :(");
            }
            beforeprevious = previous;
            previous = result;
        }

        return result;
    }

    private static long[] stack = new long[93];

    public static long fibRecursive(int index) {
        if (index > 92) throw new IllegalArgumentException("Túl sokadik elemet kéred. :(");
        if (index < 1) return 0;
        if (index == 1) return 1;
        if (stack[index] == 0) {
            stack[index] = fibRecursive(index - 2) + fibRecursive(index - 1);
        }
        return stack[index];
    }
}
//Készíts egy osztályt Fibonacci néven!
// Legyen benne egy fib metódus, ami egy int n paramétert vár!
// A visszatérési értékünk legyen egy long szám, ami az n-edik fibonacci számot tartalmazza.
//
// (A fibonacci szám az az az előző kettő fibonacci szám összege és az első két szám az 1, 1.
//
//Bónusz feladat: implementáld az algoritmust ciklus nélkül és mentsd el a részeredményeket egy statikus változóba!
//
//Pontosítás: Ha n = 0, akkor 0-t adunk vissza, ha n = 1, akkor 1-et, ezért lesz a 2. elem szintén 1, mert 0 + 1 = 1