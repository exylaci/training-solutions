package week13.d01;

public class Settlement {
    public static final String DELIMITER = ";";
    public static final int POSITION_ZIPCODE = 0;
    public static final int POSITION_NAME = 1;
    public static final int POSITION_DISTRICT = 2;

    private String zipCode;
    private String name;
    private String district;

    public Settlement(String zipCode, String name, String district) {
        this.zipCode = zipCode;
        this.name = name;
        this.district = district;
    }

    public Settlement(String string) {
        String[] parts = string.split(DELIMITER);
        if (parts.length > POSITION_ZIPCODE) {
            zipCode = parts[POSITION_ZIPCODE];
        }
        if (parts.length > POSITION_NAME) {
            name = parts[POSITION_NAME];
        }
        if (parts.length > POSITION_DISTRICT) {
            district = parts[POSITION_DISTRICT];
        }
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        return "(" + zipCode + ' ' + name + ", " + district + ")\n";
    }
}