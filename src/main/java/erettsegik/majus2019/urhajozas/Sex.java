package erettsegik.majus2019.urhajozas;

public enum Sex {
    MALE("F", "férfi"), FEMALE("N", "nő");

    String value;
    String description;

    Sex(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static Sex of(String value) {
        for (Sex sex : Sex.values()) {
            if (sex.value.equals(value)) {
                return sex;
            }
        }
        throw new IllegalArgumentException("Invalid Sex value!");
    }
}
