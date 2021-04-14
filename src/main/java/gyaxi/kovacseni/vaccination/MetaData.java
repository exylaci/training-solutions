package gyaxi.kovacseni.vaccination;

import java.time.LocalDate;

public class MetaData {
    private final Town town;
    private final LocalDate date;

    public MetaData(String zip, String city, LocalDate date) {
        this.town = new Town(zip, city);
        this.date = date;
    }

    public String getPostalCode() {
        return town.getZip();
    }

    public String getTownName() {
        return town.getName();
    }

    public LocalDate getDate() {
        return date;
    }

    public Town getTown() {
        return town;
    }
}