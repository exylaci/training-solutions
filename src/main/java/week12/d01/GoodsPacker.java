package week12.d01;

import java.util.*;
import java.util.stream.Collectors;

public class GoodsPacker {

    public int packGoods(int[][] types, int capacity) {
        if (types == null) return 0;

        List<Type> typeList = Arrays.stream(types).map(a -> new Type(a[0], a[1])).sorted().collect(Collectors.toList());
        int result = 0;
        for (Type type : typeList) {
            while (capacity - type.getWeight() >= 0) {
                capacity -= type.getWeight();
                result += type.getPrice();
            }
        }
        return result;
    }
}
//Készíts egy GoodsPacker osztályt, melynek van egy
//
// int packGoods(int[][] types, int capacity)
//
//metódusa. A types tömb számpárokat tartalmaz, melyek tárgyak súlyát és értékét tartalmazzák,
//Az első szám a súly kilogrammban, a második szám az érték forintban.
//
//A feladat az, hogy kiszámoljuk, hogy a megadott táskamérethez (capacity) mennyi a tárgyak maximum értéke,
//amit belepakolhatunk a táskába.
//
// Például:
// types = [(7, 160), (3, 90), (2, 15)]
// capacity = 20
// --->  maximum érték = 555.