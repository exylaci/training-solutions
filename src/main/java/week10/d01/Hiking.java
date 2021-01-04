package week10.d01;

import java.util.List;

public class Hiking {
    public double getPlusElevation(List<Double> levels) {
        if (levels == null) throw new IllegalArgumentException("Levels list is a must!");

        double result = 0;
        for (int i = 1; i < levels.size(); ++i) {
            result += Math.max(levels.get(i) - levels.get(i - 1), 0);
        }
        return result;
    }
}
//Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot
// (mindegyik lebegőpontos érték).
//
//Írj a week10d01.Hiking osztályba egy getPlusElevation() metódust, mely megkapja a magasságok listáját, és visszaadja
//az emelkedések összegét. Azaz pl. 10,20,15,18 esetén 13, ugyanis (20 - 10) + (18 - 15).
//
// A 20 méterről 15 méterre ereszkedést nem számolja bele, hiszen az ereszkedés, és nem emelkedés.