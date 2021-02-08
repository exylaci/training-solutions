package week15.d01;

import java.util.List;

public class Bitcoin {
    public Dates findBestDates(List<Integer> rates) {

        int[] distances = new int[rates.size()];
        for (int i = 0; i < distances.length; ++i) {
            for (int j = i; j < distances.length; ++j) {
                distances[i] = Math.max(rates.get(j) - rates.get(i), distances[i]);
            }
        }

        Dates result = new Dates(0, 0);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < distances.length; ++i) {
            if (distances[i] > max) {
                result.setBuyOn(i);
                max = distances[i];
            }
        }

        max = Integer.MIN_VALUE;
        for (int i = result.getBuyOn(); i < rates.size(); ++i) {
            if (rates.get(i) > max) {
                result.setSaleOn(i);
                max = rates.get(i);
            }
        }
        return result;
    }
}
//Egy befektető cég szeretné megnézni, hogy az elmúlt időszakban mikor lett volna érdemes venni, illetve eladni Bitcoint.
// Készíts egy metódust, ami paraméterül várja a Bitcoin, valahány napi árfolyamát időrendi sorrendben egy listában,
// dollárban. (Egész számok listája) A metódus visszatérési értéke két szám legyen, az első hogy hányadik napon lett
// volna érdemes venni, a második pedig, hogy melyik napon lett volna érdemes eladni. Mindezt úgy, hogy a legnagyobb
// nyereségünk legyen. (edited)