package erettsegik.majus2019.cegesautok;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CarPark {
    public static final String SEPARATOR = " ";

    private int day;
    private LocalTime time;
    private String plateNumber;
    private int employeeId;
    private int counter;
    private Direction direction;

    private CarPark(int day, LocalTime time, String plateNumber, int employeeId, int counter, Direction direction) {
        this.day = day;
        this.time = time;
        this.plateNumber = plateNumber;
        this.employeeId = employeeId;
        this.counter = counter;
        this.direction = direction;
    }

    public static CarPark of(String allData) {
        String[] parts = allData.split(SEPARATOR);
        if (parts.length < 6) {
            throw new IllegalArgumentException("Túl kevés adat egy parkoláshoz!");
        }
        try {
            return new CarPark(
                    Integer.parseInt(parts[0]),
                    LocalTime.parse(parts[1], DateTimeFormatter.ofPattern("H:m")),
                    parts[2],
                    Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]),
                    Direction.of(parts[5]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Hibás szám adat!");
        }
    }

    public static String getSEPARATOR() {
        return SEPARATOR;
    }

    public int getDay() {
        return day;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCounter() {
        return counter;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "CarPark{" +
                "day=" + day +
                ", time=" + time +
                ", plateNumber='" + plateNumber + '\'' +
                ", employeeId=" + employeeId +
                ", counter=" + counter +
                ", direction=" + direction +
                "}\n";
    }
}
