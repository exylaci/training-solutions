package defaultconstructor.date;

public enum CountryCode {
    HU("y-m-d"),
    EN("d-m-y"),
    US("m-d-y");

    private final String dateFormat;

    CountryCode(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDateFormat() {
        return dateFormat;
    }
}
