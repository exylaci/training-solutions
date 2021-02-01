package week14.d01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Indexer {

    public Map<Character, List<String>> index(List<String> names) {
        Map<Character, List<String>> result = new HashMap<>();
        if (names == null) return result;

        for (String name : names) {
            Character firstletter = name.toUpperCase().charAt(0);
            if (!result.containsKey(firstletter)) {
                result.put(firstletter, new ArrayList<>());
            }
            result.get(firstletter).add(name);
        }
        return result;
    }
}
//Készíts egy Indexer osztályt, melynek van egy public Map<Character, List<String>> index(List<String> names) metódusa.
//A feladat az, hogy egy indexet készítsünk a megadott nevek kezdőbetűiből (minden kezdőbetűt társítsunk az összes
//névvel, mely ezzel a betűvel kezdődik).
//
//Példa:
//System.out.println(new Indexer().index(Arrays.asList("Odon", "Lujza", "Abraham", "Magdolna", "Adam")));
// {A=[Abraham, Adam], L=[Lujza], M=[Magdolna], O=[Odon]}
