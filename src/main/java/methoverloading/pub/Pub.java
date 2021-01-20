package methoverloading.pub;

import methoverloading.time.Time;

public class Pub {
    private String name;
    private int hours;
    private int minutes;

    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time getOpenFrom() {
        return new Time(hours, minutes);
    }

    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return String.format("%s;%d:%d", name, hours, minutes);
    }
}
