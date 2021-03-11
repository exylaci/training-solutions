package erettsegik.oktober2020.sorozatok;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Episode {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private LocalDate onAirDate;
    private String title;
    private String episode;
    private int length;
    private boolean seen;

    public Episode(String[] values) {
        if (!values[0].equals("NI")) {
            this.onAirDate = LocalDate.parse(values[0], DATE_FORMATTER);
        }

        this.title = values[1];
        this.episode = values[2];
        this.length = Integer.parseInt(values[3]);
        this.seen = values[4].equals("1");
    }

    public LocalDate getOnAirDate() {
        return onAirDate;
    }

    public static DateTimeFormatter getDateFormatter() {
        return DATE_FORMATTER;
    }

    public String getTitle() {
        return title;
    }

    public String getEpisode() {
        return episode;
    }

    public int getLength() {
        return length;
    }

    public boolean isSeen() {
        return seen;
    }

    @Override
    public String toString() {
        return onAirDate + " " + title + " " + episode + " " + length + " " + seen;
    }
}
