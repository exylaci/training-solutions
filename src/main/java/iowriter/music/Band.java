package iowriter.music;

public class Band {
    private String name;
    private int year;

    public Band(String band, int year) {
        this.name = band;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s;%d", name, year);
    }
}