package methodstructure.pendrives;

import java.util.ArrayList;
import java.util.List;

public class Pendrives {
    private List<Pendrive> pendrives = new ArrayList<>();

    public Pendrive best( List<Pendrive> pendrives ){
        Pendrive currentBest = new Pendrive("temp",1,Integer.MAX_VALUE);
        for ( Pendrive pendrive : pendrives ){
            if ( pendrive.comparePricePerCapacity(currentBest) <= 0 ){
                currentBest=pendrive;
            }
        }
        return currentBest;
    }

    public Pendrive cheapest(List<Pendrive> pendrives){
        Pendrive currentBest = new Pendrive("temp",1,Integer.MAX_VALUE);
        for ( Pendrive pendrive : pendrives ){
            if ( pendrive.cheaperThan(currentBest) ){
                currentBest=pendrive;
            }
        }
        return currentBest;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity){
        for ( Pendrive pendrive : pendrives ){
            if ( pendrive.getCapacity()==capacity ){
                pendrive.risePrice(percent);
            }
        }
    }

}
// Legyen Pendrive best(List<Pendrive>) metódusa,
//    amely a legjobb ár/kapacitás értékű pendrive-t adja vissza, azaz amelyiknél ez a legkisebb.
// Legyen Pendrive cheapest(List<Pendrive>) metódusa, amely a legolcsóbbat adja vissza.
// Legyen void risePriceWhereCapacity(List<Pendrive>, int percent, int capacity) metódusa,
//    amely adott százalékkal megemeli azon pendrive-ok árát, amelynek a kapacitása a megadott értékkel megegyezik.