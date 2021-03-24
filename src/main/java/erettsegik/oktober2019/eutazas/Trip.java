package erettsegik.oktober2019.eutazas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Trip {
    public static final String SEPARATOR = " ";
    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm");
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");

    private int stop;
    private LocalDateTime timeStamp;
    private String passId;
    private Type type;
    private LocalDate valid;
    private int round;

    public Trip(String allData) {
        String[] parts = allData.split(SEPARATOR);
        stop = Integer.parseInt(parts[0]);
        timeStamp = LocalDateTime.parse(parts[1], DATETIME_FORMAT);
        passId = parts[2];
        type = Type.valueOf(parts[3]);
        if (type.isSeasonPass()) {
            valid = LocalDate.parse(parts[4], DATE_FORMAT);
        } else {
            round = Integer.parseInt(parts[4]);
        }
    }

    public int getStop() {
        return stop;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getPassId() {
        return passId;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getValid() {
        return valid;
    }

    public int getRound() {
        return round;
    }

    public boolean notValid() {
        if (type.isSeasonPass()) {
            return timeStamp.toLocalDate().isAfter(valid);
        }
        return round < 1;
    }
}
