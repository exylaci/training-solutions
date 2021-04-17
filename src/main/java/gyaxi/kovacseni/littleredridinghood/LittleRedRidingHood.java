package gyaxi.kovacseni.littleredridinghood;

import java.util.Objects;

public class LittleRedRidingHood extends Forest {
    protected static int cake = 10;
    private final String name;

    public LittleRedRidingHood(String name) {
        this.name = name;
    }

    public static void giveCake(int pieces) {
        cake -= pieces;
    }

    @Override
    public void eat() {
        --cake;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LittleRedRidingHood that = (LittleRedRidingHood) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}