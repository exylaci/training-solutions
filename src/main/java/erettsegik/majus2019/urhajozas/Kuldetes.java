package erettsegik.majus2019.urhajozas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Kuldetes {
    private static final String SEPARATOR = "\t";
    private static final String INVALID_DATA = "Invalid data.";

    private final int id;
    private final String title;
    private final LocalDate begin;
    private final LocalDate end;

    private Kuldetes(int id, String title, LocalDate begin, LocalDate end) {
        this.id = id;
        this.title = title;
        this.begin = begin;
        this.end = end;
    }

    public static Kuldetes of(String all) {
        String[] parts = all.split(SEPARATOR);
        if (parts.length != 4) {
            throw new IllegalArgumentException(INVALID_DATA);
        }
        try {
            return new Kuldetes(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("yyyy.MM.dd")),
                    LocalDate.parse(parts[3], DateTimeFormatter.ofPattern("yyyy.MM.dd")));
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new IllegalArgumentException(INVALID_DATA);
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public LocalDate getEnd() {
        return end;
    }
}
