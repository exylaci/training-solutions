package week04.d02;

import java.util.ArrayList;
import java.util.List;

public class Search {
    public List<Integer> getIndexesOfChar(String base, String part) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < base.length() - part.length() + 1; ++i) {
            if (base.substring(i, i + part.length()).equals(part)) {
                result.add(i);
            }
        }
        return result;
    }
}
//A Search osztályban írj egy 
// getIndexesOfChar() metódust, mely első paraméterként vár egy 
// String értéket, második paraméterként egy 
// char értéket! 
// 
// Visszaad egy listát, melyben visszaadja, hogy a 
// karakter hanyadik indexeken szerepel az első paraméterként átadott listában.
//
//Pl.: almafa szóban a a karakter: 0, 3, 5.