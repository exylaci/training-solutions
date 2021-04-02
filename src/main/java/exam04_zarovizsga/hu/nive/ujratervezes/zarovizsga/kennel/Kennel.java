package exam04_zarovizsga.hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {
    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return Collections.unmodifiableList(dogs);
    }

    public void feedAll() {
        dogs.forEach(Dog::feed);
    }

    public Dog findByName(String name) {
        return dogs
                .stream()
                .filter(dog -> dog.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Nincs " + name + " nevű kutya a kennelben!"));
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int limit) {
        return dogs
                .stream()
                .filter(dog -> dog.getHappiness() > limit)
                .map(Dog::getName)
                .collect(Collectors.toList());
    }
}
