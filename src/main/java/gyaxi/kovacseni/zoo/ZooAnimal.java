package gyaxi.kovacseni.zoo;

import java.util.Objects;

public class ZooAnimal {
    private final String name;
    private final int length;
    private final long weight;
    private final AnimalType type;

    public ZooAnimal(String name, int length, long weight, AnimalType type) {
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public long getWeight() {
        return weight;
    }

    public AnimalType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ZooAnimal)) return false;
        return name.equals(((ZooAnimal) o).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}