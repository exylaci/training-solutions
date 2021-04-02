package exam04retake2.hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Aquarium {
    private List<Fish> fishes = new ArrayList<>();


    public List<String> getStatus() {
        return fishes.stream().map(Fish::status).collect(Collectors.toList());
    }

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feed() {
        fishes.forEach(Fish::feed);
    }

    public void removeFish() {
        Iterator<Fish> iterator = fishes.iterator();

        while (iterator.hasNext()) {
            Fish fish = iterator.next();
            if (fish.getWeight() >= 11) {
                iterator.remove();
            }
        }
    }
}
