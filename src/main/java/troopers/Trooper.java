package troopers;

public class Trooper {
    public static final String ERROR_MESSAGE_NAME = "Name must not be empty.";
    public static final String ERROR_MESSAGE_POSITION = "Position is a must.";
    private String name;
    private Position position;

    public Trooper(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME);
        }
        this.name = name;
        this.position = new Position(0, 0);
    }

    public double distanceFrom(Position target) {
        return position.distanceFrom(target);
    }

    public void changePosition(Position position) {
        if (position == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE_POSITION);
        }
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
