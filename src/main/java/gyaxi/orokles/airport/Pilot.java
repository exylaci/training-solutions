package gyaxi.orokles.airport;

public class Pilot extends Person {
    private final Position position;

    public Pilot(String name, Integer age, Position position) {
        super(name, age);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public Type getType() {
        return Type.PILOT;
    }
}