package gyaxi.kovacseni.dogs;

import java.util.Locale;

public class Dog {
    public static final String SPLITTER = ";";

    private String name;
    private String country;
    private String url;

    public static Dog fromString(String allData) {
        String[] parts = allData.split(SPLITTER);
        if (parts.length < 6) {
            throw new IllegalArgumentException("Too few data for create a Dog!");
        }
        return new Dog(parts[1], parts[4], parts[5]);
    }

    public Dog(String name, String country, String url) {
        this.name = name;
        this.country = country;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getUrl() {
        return url;
    }
}
