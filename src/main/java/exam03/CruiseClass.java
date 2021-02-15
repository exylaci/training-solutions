package exam03;

public enum CruiseClass {
    LUXURY(3.), FIRST(1.8), SECOND(1.);

    private final double value;

    CruiseClass(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}