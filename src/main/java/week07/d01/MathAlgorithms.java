package week07.d01;

public class MathAlgorithms {

    public static boolean isPrim(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Csak pozitív egész szám!");
        }
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0 || value == 1) {
            return false;
        }

        int limit = (int) Math.sqrt(value) + 1;
        for (int i = 3; i < limit; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrim(long number) {
        if (number < 1) {
            throw new IllegalArgumentException("Csak pozitív egész szám!");
        }

        int numberOfDividers = 0;
        for (long i = 1; i <= number; ++i) {
            if (number % i == 0) {
                ++numberOfDividers;
            }
        }
        if (numberOfDividers == 2) {
            return true;
        }
        return false;
    }
}
//Készíts egy osztályt MathAlgorithms néven. Ebben az osztályban legyen egy
// isPrime(int x) metódus ami a paraméterül kapott számról eldönti, hogy prím-e vagy sem és ennek megfelelően
//  true vagy false értékkel tér vissza.
//
//  Aki már tart ott és tudja mit jelent a static az nyugodtan implementálhatja a metódust statikus metódusként.

//  Az egyszerűség kedvért a prímeket most csak a pozitív egész számok körében értelmezzük,
//  így bónuszként rá lehet ellenőrizni, hogy x > 0, és ha nem, akkor kivételt dobni.
//  Prímeknek tekintjük azokat számokat melyek csak egyel és önmagukkal oszthatók, tehát a 2, 3, 5, 7, 11, 13 stb.