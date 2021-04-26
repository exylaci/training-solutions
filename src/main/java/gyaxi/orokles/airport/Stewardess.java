package gyaxi.orokles.airport;

import java.util.Objects;

public class Stewardess extends Person {
    private final Position position;

    public Stewardess(String name, Position position) {
        super(name);
        this.position = position;
    }

    public Stewardess(String name, Integer age, Position position) {
        super(name, age);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public Type getType() {
        return Type.STEWARDESS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stewardess that = (Stewardess) o;
        return position == that.position && super.getName().equals(((Stewardess) o).getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, super.getName());
    }
}