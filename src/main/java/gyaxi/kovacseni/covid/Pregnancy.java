package gyaxi.kovacseni.covid;

public enum Pregnancy {
    YES("igen"), NO("nem"), BREAST_FEED("szoptatós anya");

    String value;

    Pregnancy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Pregnancy selectPregnacy(String value) {
        for (Pregnancy pregnancy : Pregnancy.values()) {
            if (pregnancy.getValue().equals(value)) {
                return pregnancy;
            }
        }
        throw new IllegalArgumentException("No such type of Pregnacy");
    }

    public boolean isPregnant() {
        return value == YES.value || value == BREAST_FEED.value;
    }
}