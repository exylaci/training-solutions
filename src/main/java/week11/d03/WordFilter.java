package week11.d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {
    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> result = new ArrayList<>();
        if (words == null) return result;

        for (String word : words) {
            if (word != null && word.indexOf(c) >= 0) {
                result.add(word);
            }
        }
        return result;
    }
}
//Készíts egy WordFilter osztályt, melyben van egy List<String> wordsWithChar(List<String> words, char c) metódus.
// A metódus kiválógatja a paraméterül kapott String listából azokat a szavakat, melyekben előfordul a c karakter,
// majd ezeket visszaadja egy listában.