package gyaxi.adatbazis.book;

import java.time.LocalDate;

public class PublisherCompany {
    private final int id;
    private final String name;
    private final String address;
    private final String email;
    private final LocalDate establish;

    public PublisherCompany(int id, String name, String address, String email, LocalDate establish) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.establish = establish;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getEstablish() {
        return establish;
    }
}