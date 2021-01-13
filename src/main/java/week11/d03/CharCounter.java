package week11.d03;

import java.util.HashSet;
import java.util.Set;

public class CharCounter {
    public int countCharsWithSet(String[] strings) {
        if (strings == null || strings.length < 2) return 0;

        Set<Character> temp = convertToSet(strings[0]);
        for (int index = 1; index < strings.length; ++index) {
            temp.retainAll(convertToSet(strings[index]));
        }
        return temp.size();
    }

    private Set<Character> convertToSet(String source) {
        Set<Character> result = new HashSet<>();
        if (source != null) {
            for (char c : source.toCharArray()) {
                result.add(c);
            }
        }
        return result;
    }

    public int countChars(String[] strings) {
        if (strings == null || strings.length < 2 || strings[0] == null) return 0;

        int result = 0;
        for (int i = 0; i < strings[0].length(); ++i) {
            while (strings[0].substring(i + 1).indexOf(strings[0].charAt(i)) >= 0) {
                ++i;
            }
            if (numberOfContaining(strings[0].charAt(i), strings) == strings.length - 1) {
                ++result;
            }
        }
        return result;
    }

    private int numberOfContaining(char character, String[] strings) {
        int result = 0;
        for (int i = 1; i < strings.length; ++i) {
            if (strings[i] != null && strings[i].indexOf(character) >= 0) {
                ++result;
            }
        }
        return result;
    }
}
//Készítsünk egy CharCounter osztályt, melyben van egy int countChars(String[] chars) metódus. A feladat az, hogy
// összeszámoljuk azokat a karaktereket asz összes chars-ban lévő String-ből, amelyek mindegyik String-ben szerepelnek.
//
//Példa:
// Ha a chars-ban ["abc", "cba", "ab"] szerepel, akkor a visszatérési érték 2, mert az a és a b karakter szerepel
// mindegyik String-ben.