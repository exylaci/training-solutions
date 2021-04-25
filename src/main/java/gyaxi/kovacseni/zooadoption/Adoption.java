package gyaxi.kovacseni.zooadoption;

import java.time.LocalDate;
import java.util.Objects;

public class Adoption {
    private final String animal;
    private final LocalDate adoptionDate;

    public Adoption(String animal, LocalDate adoptionDate) {
        this.animal = animal;
        this.adoptionDate = adoptionDate;
    }

    public String getAnimal() {
        return animal;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adoption adoption = (Adoption) o;
        return Objects.equals(animal, adoption.animal) && Objects.equals(adoptionDate, adoption.adoptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animal, adoptionDate);
    }
}