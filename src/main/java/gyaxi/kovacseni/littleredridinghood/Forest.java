package gyaxi.kovacseni.littleredridinghood;

import java.util.ArrayList;
import java.util.List;

public abstract class Forest {
    public static ArrayList<Forest> playersOfTheTale = new ArrayList(List.of(
            new LittleRedRidingHood("Piroska"), new Wolf("Farkas"), new Grandma("Nagymama"), new Hunter("Vadász")));

    public abstract void eat();
}