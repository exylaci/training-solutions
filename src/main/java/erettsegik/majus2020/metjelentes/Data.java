package erettsegik.majus2020.metjelentes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Data {
    public static final String SEPARATOR = " ";
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmm");

    private String city;
    private LocalTime time;
    private String wind;
    private int temperature;

    public Data(String all) {
        String[] parts = all.split(SEPARATOR);
        this.city = parts[0];
        this.time = LocalTime.parse(parts[1], TIME_FORMATTER);
        this.wind = parts[2];
        this.temperature = Integer.parseInt(parts[3]);
    }

    public String getCity() {
        return city;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getWind() {
        return wind;
    }

    public int getWindPower() {
        return Integer.parseInt(wind.substring(3));
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %2d%n", city, time.format(DateTimeFormatter.ofPattern("hh:mm")), wind, temperature);
    }
}
