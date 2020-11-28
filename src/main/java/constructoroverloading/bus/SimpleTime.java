package constructoroverloading.bus;

import java.time.LocalTime;

public class SimpleTime {
    public static String ERROR_MESSAGE = "Time cannot be null!";
    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this(hours);
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this.hours = hours;
    }

    public SimpleTime(SimpleTime time) {
        this.hours = time.hours;
        this.minutes = time.minutes;
    }

    public int difference(SimpleTime time) {
        checkNull(time);
        return (hours - time.getHours()) * 60 + minutes - time.getMinutes();
    }

    private void checkNull(SimpleTime time) {
        if (time == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}
