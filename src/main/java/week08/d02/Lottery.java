package week08.d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {


    public static List<Integer> getNumbers() {
        return getNumbers(90, 5);
    }

    //Ha van már ilyen szám, újra próbálkozik random szémmal.
    public static List<Integer> getNumbers(int MaxValue, int pieces) {
        if (pieces > MaxValue) throw new IllegalArgumentException("Impossible conditions!");

        List<Integer> result = new ArrayList<>();
        Random random = new Random();

        while (result.size() < pieces) {
            int next = random.nextInt(MaxValue) + 1;
            if (!result.contains(next)) {
                result.add(next);
            }
        }
        return result;
    }

    //Listába behelyezett számok közűl választ ki egyet.
    public static List<Integer> getNumbers(int MaxValue, int pieces, int seed) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= MaxValue; ++i) {
            numbers.add(i);
        }

        List<Integer> result = new ArrayList<>();
        Random random = new Random(seed);
        while (result.size() < pieces && numbers.size() > 0) {
            int next = random.nextInt(numbers.size());
            result.add(numbers.get(next));
            numbers.remove(next);
        }

        return result;
    }
}
//Készíts a week08d02 csomagban egy Lottery osztályt, melynek legyen egy
// getNumbers() metódusa, ami visszaad egy listát amiben 5 véletlen szám van 1-90 között,
// tehát kvázi készíts egy lottósorsoló programot. A sorrendre nem kell figyelni, a lényeg,
// hogy a számok különbözők legyenek! (edited)