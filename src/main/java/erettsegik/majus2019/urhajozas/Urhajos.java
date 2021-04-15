package erettsegik.majus2019.urhajozas;

import java.util.Locale;

public class Urhajos {
    private static final String SEPARATOR = "\t";
    private static final String INVALID_LINE = "Invalid line!";

    private final int id;
    private final String name;
    private final String country;
    private final Sex sex;
    private final int born;
    private final String spentTime;

    public Urhajos(int id, String name, String country, Sex sex, int born, String spentTime) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.sex = sex;
        this.born = born;
        this.spentTime = spentTime;
    }

    public static Urhajos parse(String all) {
        String[] parts = all.split(SEPARATOR);
        if (parts.length != 6) {
            System.out.println(parts.length);
            System.out.println(all);
            throw new IllegalArgumentException(INVALID_LINE);
        }
        try {
            return new Urhajos(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    Sex.of(parts[3].toUpperCase()),
                    Integer.parseInt(parts[4]),
                    parts[5]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_LINE);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Sex getSex() {
        return sex;
    }

    public int getBorn() {
        return born;
    }

    public String getSpentTime() {
        return spentTime;
    }
}