package gyaxi.kovacseni.zoo;

import javax.sql.DataSource;
import java.util.*;
import java.util.stream.Collectors;

public class Zoo {
    private final Dao dao;
    private Set<ZooAnimal> animals = new HashSet<>();

    public Zoo(DataSource dataSource) {
        dao = new Dao(dataSource);
    }

    public HashSet<ZooAnimal> getAnimals() {
        return new HashSet<>(animals);
    }

    public void loadAnimals() {
        animals.addAll(dao.loadAnimals());
    }

    public void addAnimal(ZooAnimal animal) {
        animals.add(animal);
    }

    public ZooAnimal getHeaviestAnimalInTheZoo() {
        return animals
                .stream()
                .max(Comparator.comparing(ZooAnimal::getWeight))
                .orElseThrow(() -> new IllegalStateException("There is no animal in the zoo at all :("));
    }

    public long countWeights() {
        return animals
                .stream()
                .mapToLong(ZooAnimal::getWeight)
                .sum();
    }

    public ZooAnimal findExactAnimal(ZooAnimal findThis) {
        return animals
                .stream()
                .filter(animal -> animal.equals(findThis))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public ZooAnimal findExactAnimalByName(String name) {
        return animals
                .stream()
                .filter(animal -> animal.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("There is no such animal in the zoo!"));
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public List<ZooAnimal> getAnimalsOrderedByName() {
        return animals
                .stream()
                .sorted(Comparator.comparing(ZooAnimal::getName))
                .collect(Collectors.toList());
    }

    public Map<AnimalType, Integer> getAnimalStatistics() {
        return animals
                .stream()
                .collect(Collectors.toMap(ZooAnimal::getType, t -> 1, Integer::sum));
    }
}