package week13.d02;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Plane {
    public static final String SEPARATOR = ":";
    public static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("HH:mm");

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
        String[] parts = time.split(SEPARATOR);
        this.time = LocalTime.of(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
//        this.time = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("HH:mm")).toLocalTime();
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