package methoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {
    List<Pub> pubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> pubs) {
        if (pubs == null || pubs.size() == 0) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.pubs = new ArrayList<>(pubs);
    }

    public Pub findTheBest() {
        Pub best = new Pub("temp", 23, 59);
        for (Pub one : pubs) {
            if (one.getOpenFrom().isEarlier(best.getOpenFrom())) {
                best = one;
            }
        }
        return best;
    }
}
