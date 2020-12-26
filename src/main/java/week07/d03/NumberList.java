package week07.d03;

import java.util.List;

public class NumberList {
    public static boolean isIncreasing(List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) throw new IllegalArgumentException("The list is empty!");

        for (int i = 1; i < numbers.size(); ++i) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                return false;
            }
        }
        return true;
    }
}
//Hozz létre egy NumberList osztályt! Ennek legyen egy metódusa
// isIncreasing(List<Integer>),
//  mely egy számokból álló listát vár paraméterül és megnézi, hogy a listában a számok növekvő sorrendben szerepelnek-e
//  és ennek megfelelően igaz vagy hamis értékkel tér vissza!
//
// Speciális eset ha két egymást követő szám egyenlő, ez nem probléma a 1, 2, 3, 3, 3, 5 számokat növekvőnek tekintjük.