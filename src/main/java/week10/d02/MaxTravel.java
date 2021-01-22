package week10.d02;

import java.util.*;
import java.util.stream.Collectors;

public class MaxTravel {
    public int getMaxIndex(List<Integer> passengers) {
        if (passengers == null) throw new IllegalArgumentException("The passengers list is a must!");

        Optional<Map.Entry<Integer, Long>> op =
                passengers
                        .stream()
                        .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Comparator.comparing(Map.Entry::getKey))
                        .max((a, b) -> (int) (a.getValue() - b.getValue()));

        return op.get().getKey();
    }

//    public int getMaxIndex(List<Integer> passengers) {
//        if (passengers == null) throw new IllegalArgumentException("The passengers list is a must!");
//
//        int[] stops = new int[30];
//        for (Integer passenger : passengers) {
//            ++stops[passenger];
//        }
//
//        int stop = -1;
//        int max = -1;
//        for (int i = 0; i < stops.length; ++i) {
//            if (stops[i] > max) {
//                max = stops[i];
//                stop = i;
//            }
//        }
//        return stop;
//    }
}
//Van egy egész számok listája, amelyben egy szám azt jelzi, hogy az adott számú buszmegállóban egy ember fel akar szállni. A 12,12,0,3,4,4 sorozat tehát azt jelenti, hogy a 12-es buszmegállóban 2-en, a 0-ásban 1 ember, 3-asban egy ember, 4-esben 2 ember akar felszállni. A MaxTravel osztály getMaxIndex() metódusa adja vissza, hogy hanyas megállóban szeretnének a legtöbben felszállni. Maximum 30 megálló lehet.
//ha két megállóban ugyanannyian akarnak felszállni, akkor az első (kisebbik sorszámú) megálló azonosítóját add vissza.