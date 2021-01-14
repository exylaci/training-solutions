package week11.d04;

import java.util.*;

public class NameLength {
    public static final String FIRST_LETTER = "J";

    public List<Integer> getLengths(List<String> strings) {
        Set<Integer> length = new HashSet<>();
        if (strings != null) {

            for (String oneString : strings) {
                if (oneString != null && oneString.toUpperCase().startsWith(FIRST_LETTER)) {
                    length.add(oneString.length());
                }
            }
        }
        return new ArrayList<>(length);
    }
}
//Adott egy nevek listája. Add vissza egy listában, hogy milyen hosszúságú J karakterrel kezdődő nevek szerepelnek a
//listában! Minden szám csak egyszer szerepeljen!
//
//Ha a bemenet pl. List.of("Joe", "Jack", "Jane", "Jake", "George", "William"), a visszatérési érték [3, 4] legyen!