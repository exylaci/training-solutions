package gyaxi.algorithms;

import java.util.Arrays;

public class SmallerWith {
    public int smallerWith(int difference, int... numbers) {
        if (difference < 0) {
            throw new IllegalArgumentException("Value is out of range!");
        }
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("Every parameter is a must!");
        }

        int maximum = Arrays.stream(numbers).max().getAsInt()-difference;


        return Arrays.stream(numbers)
                .filter(number -> number<=maximum)
                .max()
                .orElseThrow(()->new IllegalStateException("There is no such number!"));
    }
}
//Add vissza azt a legnagyobb számot ami a paraméterül kapott tömb legnagyobb eleménél
//legalább a szintén paraméterül kapott számmal kisebb. (Készülj fel minden eshetőségre.)