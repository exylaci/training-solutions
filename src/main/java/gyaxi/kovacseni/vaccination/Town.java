package gyaxi.kovacseni.vaccination;

public class Town {
    private final String zip;
    private final String name;

    public Town(String zip, String name) {
        this.zip = zip;
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return zip + ", " + name;
    }
}