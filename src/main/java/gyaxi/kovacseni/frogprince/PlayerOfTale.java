package gyaxi.kovacseni.frogprince;

import java.util.Objects;

public class PlayerOfTale {
    private final String name;
    private final int age;
    private final Tale tale;

    public PlayerOfTale(String name, int age, Tale tale) {
        this.name = name;
        this.age = age;
        this.tale = tale;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Tale getTale() {
        return tale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerOfTale that = (PlayerOfTale) o;
        return age == that.age && Objects.equals(name, that.name) && tale == that.tale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, tale);
    }
}