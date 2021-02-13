package week15.d05;

import java.time.LocalDate;
import java.util.List;

public class Data {
    private LocalDate date;
    private String week;
    private int cases;
    private int deaths;
    private String country;
    private String id;
    private String code;
    private int population;
    private String continent;
    private double notification;

    public Data(List<String> oneLine) {
        cases = oneLine.get(2).isBlank() ? 0 : Integer.parseInt(oneLine.get(2));
        country = oneLine.get(4);
        population = oneLine.get(7).isBlank() ? 0 : Integer.parseInt(oneLine.get(7));
    }

    public int getCases() {
        return cases;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "Data{" +
                "cases=" + cases +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }
}
