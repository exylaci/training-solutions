package gyaxi.kovacseni.covid;

public enum ChronicDisease {
    YES("igen"), NO("nem");

    String value;

    ChronicDisease(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ChronicDisease selectChronicDisease(String value) {
        for (ChronicDisease chronicDisease : ChronicDisease.values()) {
            if (chronicDisease.getValue().equals(value)) {
                return chronicDisease;
            }
        }
        throw new IllegalArgumentException("No such type of Chronic Disease");
    }

    public boolean hasChronicDisease() {
        return value == YES.value;
    }
}