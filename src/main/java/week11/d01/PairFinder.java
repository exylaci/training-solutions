package week11.d01;

import java.util.Arrays;

public class PairFinder {

    int findPairs(int[] arr){
        if (arr==null||arr.length<2) return 0;

        Arrays.sort(arr);
        int result =0;
        for(int i=1; i<arr.length;++i){
            if(arr[i-1]==arr[i]){
                ++result;
                ++i;
            }
        }
        return result;
    }
}
//Készítsünk egy PairFinder nevű osztályt, melynek van egy int findPairs(int[] arr) metódusa.
// A feladat az, hogy a tömb elemeiből kikeressük, hogy hány darab pár van bennük.
// Ha egy szám kétszer szerepel a tömbben, akkor az egy párnak számít.
//
// Példa: A [5, 1, 4, 5] tömbben kétszer szerepel az 5, ezért a visszatérési érték 1.
// A [7, 1, 5, 7, 3, 3, 9, 7, 6, 7] tömbben négyszer szerepel a 7, ezért ez 2 párnak számít,
// illetve a 3 kétszer szerepel, így a visszatérési érték 3.
// Ha valamilyen szám 3x szerepel, az akkor csak 1 párnak minősül. (Pl. [1, 2, 1, 3, 1] a visszatérési érték 1.