package week08.d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {


    public static List<Integer> getNumbers() {
        return getNumbers(90, 5);
    }

    public static List<Integer> getNumbers(int MaxValue, int pieces) {
        if (pieces > MaxValue) throw new IllegalArgumentException("Impossible conditions!");

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        while (numbers.size() < pieces) {
            int next = random.nextInt(MaxValue) + 1;
            if (!numbers.contains(next)) {
                numbers.add(next);
            }
        }

        return numbers;
    }
}
//Készíts a week08d02 csomagban egy Lottery osztályt, melynek legyen egy
// getNumbers() metódusa, ami visszaad egy listát amiben 5 véletlen szám van 1-90 között,
// tehát kvázi készíts egy lottósorsoló programot. A sorrendre nem kell figyelni, a lényeg,
// hogy a számok különbözők legyenek! (edited)