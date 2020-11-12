package stringconcat;

public enum Title {
    MR("Mr."), MS("Ms."), DR("Dr.");

    private final String value;

    Title(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
