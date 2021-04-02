package exam04_zarovizsga.hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee implements Comparable {
    public static final String SEPARATOR = ",";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private String name;
    private LocalDate date;
    private int hours;

    public Employee(String data) {
        String[] parts = data.split(SEPARATOR);
        name = parts[0];
        hours = Integer.parseInt(parts[1]);
        date = LocalDate.parse(parts[2], DATE_FORMATTER);
    }

    public String report() {
        return name + ": " + date.format(DATE_FORMATTER);
    }

    @Override
    public int compareTo(Object o) {
        return hours - ((Employee) o).hours ;
    }
}
