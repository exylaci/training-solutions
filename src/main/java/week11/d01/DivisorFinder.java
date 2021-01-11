package week11.d01;

public class DivisorFinder {
    public int findDivisors(int n) {

        int result = 0;
        int multiplier = n;

        while (multiplier != 0) {
            if ((multiplier % 10 != 0) && (n % (multiplier % 10) == 0)) {
                ++result;
            }
            multiplier /= 10;
        }
        return result;
    }
}
//Készítsünk egy DivisorFinder nevű osztályt, melynek van egy int findDivisors(int n) metódusa.
// A feladat az, hogy megnézzük a szám minden egyes számjegyére, hogy osztója-e a számnak, majd számoljuk össze őket.
// Példa: a 425-ben az 5 osztója a számnak, ezért a visszatérési érték 1.
//
//Tehát a 425-nél azt kell megnézni, hogy a 425-nek osztója-e a 4, a 2 és az 5. Mivel ezek közül csak az 5 az osztója,
// vagyis a 3-ból 1 db szám, ezért a visszatérési érték 1.
// De pl. a 29-nél a visszateresi érték 0 lesz, a 15-nél meg 2.