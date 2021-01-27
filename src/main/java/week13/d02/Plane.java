package week13.d02;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Plane {
    public static final String SEPARATOR = ":";
    public static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("H:m");

    private String ID;
    private Direction direction;
    private String city;
    private LocalTime time;

    public Plane(String ID, Direction direction, String city, LocalTime time) {
        this.ID = ID;
        this.direction = direction;
        this.city = city;
        this.time = time;
    }

    public Plane(String ID, String direction, String city, String time) {
        this.ID = ID;
        this.direction = Direction.valueOf(direction.toUpperCase());
        this.city = city;
        this.time = LocalTime.parse(time, PATTERN);
    }

    public String getID() {
        return ID;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return ID + ": " + direction + " " + city + " " + time + "\n";
    }
}