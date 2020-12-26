package week08.d03;

import java.util.ArrayList;
import java.util.List;

public class StringLists {
    public static List<String> shortestWords(List<String> words) {
        if (words == null) return null;

        List<String> result = new ArrayList<>();
        int shortest = Integer.MAX_VALUE;

        for (String one : words) {
            if (one.length() < shortest) {
                result.clear();
                result.add(one);
                shortest = one.length();
            } else if (one.length() == shortest) {
                result.add(one);
            }
        }
        return result;
    }

    public static List<String> stringListsUnion(List<String> first, List<String> second) {
        if (first == null || second == null) return null;

        List<String> result = new ArrayList<>(first);

        for (String one : second) {
            if (!result.contains(one)) {
                result.add(one);
            }
        }

        return result;
    }

    public static List<String> stringListsCrossSection(List<String> first, List<String> second) {
        if (first == null || second == null) return null;

        List<String> result = new ArrayList<>();

        for (String one : first) {
            if (second.contains(one) && !result.contains(one)) {
                result.add(one);
            }
        }

        return result;
    }
}
//Készíts a week08d03 csomagban egy StringLists osztályt és benne egy
// shortestWords(List<String> words) metódust, mely paraméterül kap egy
// String listát és a legrövidebb szavakat vissza adja belőle egy Listában.
// PL :{"aaa", "aa", "bb", "cccc", "dd"} Itt a
// legrövidebb szavak az "aa", "bb", "cc".

//Készíts week08d03 csomagban egy StringLists osztályt és benne egy
// stringListsUnion(List<String> first, List<String> second) metódust,
// mely két string listát vár paraméterül és visszaadja az uniójukat.
// Az úniónak minden elemet tartalmaznia kell mindkét listából, de egy elem nem szerepelhet kétszer!