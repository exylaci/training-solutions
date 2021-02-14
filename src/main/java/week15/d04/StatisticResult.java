package week15.d04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StatisticResult {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

    private LocalDate date;
    private String week;
    private String country;
    private long cases;

    public StatisticResult() {
        country = "";
    }

    public StatisticResult(String date, String week, String cases, String country) {
        this.date = LocalDate.parse(date, formatter);
        this.week = week.trim();
        this.country = country.trim();
        this.cases = cases.isBlank() ? 0 : Integer.parseInt(cases);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCountry() {
        return country;
    }

    public long getCases() {
        return cases;
    }

    @Override
    public String toString() {
        return "StatisticResoult{" +
                "date=" + date +
                ", week='" + week + '\'' +
                ", country='" + country + '\'' +
                ", cases=" + cases +
                '}';
    }
}