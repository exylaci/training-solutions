package collectionsset.collectionstreeset;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class WordFilter {
    public Set<String> filterWords(String[] randomStrings) {

        Set<String> result = new TreeSet<>();
        result.addAll(Arrays.asList(randomStrings));
        return result;
    }
}
//Egy String tömbből akarjuk kiszűrni az egyedi elemeket, és ezeket sorba is akarjuk rendezni, natív order,
//  azaz itt abc szerint.
//
//A WordFilter osztályban a következő publikus metódus található (ez persze a tesztesetekből is következik):
//  public Set<String> filterWords(String[] randomStrings)
//
//Megvalósítás
//Használjuk ki a TreeSet rendezettségét. A tesztelés során megvizsgáljuk a Set várható méretét,
//  valamint a kollekció első és utolsó elemét!