package gyaxi.kovacseni.ladybird;


import java.util.Objects;

public class Ladybug {
    private final String hungarianName;
    private final String latinName;
    private final String genius;
    private final int numberOfPoints;

    public Ladybug(String hungarianName, String latinName, String genius, int numberOfPoints) {
        this.hungarianName = hungarianName;
        this.latinName = latinName;
        this.genius = genius;
        this.numberOfPoints = numberOfPoints;
    }

    public String getHungarianName() {
        return hungarianName;
    }

    public String getLatinName() {
        return latinName;
    }

    public String getGenius() {
        return genius;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return hungarianName.equals(((Ladybug) o).hungarianName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hungarianName);
    }
}
