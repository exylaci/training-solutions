package collectionsmap;

import java.time.LocalDate;

public class Entry {
    private String ipAddress;
    private LocalDate date;
    private String login;

    public Entry(String ipAddress, LocalDate date, String login) {
        this.ipAddress = ipAddress;
        this.date = date;
        this.login = login;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDate getEntryDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }
}