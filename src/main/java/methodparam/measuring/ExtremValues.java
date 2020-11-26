package methodparam.measuring;

public class ExtremValues {
    private final double minimum;
    private final double maximum;

    public ExtremValues(double minimum, double maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public double getMin() {
        return minimum;
    }

    public double getMax() {
        return maximum;
    }
}
