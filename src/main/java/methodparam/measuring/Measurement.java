package methodparam.measuring;

public class Measurement {
    private double[] measurments;
//    = {3.14,0,13.5,6,1.41,4.2,1/3.};

    public Measurement(double[] measurments) {
        this.measurments = measurments;
    }

    public int findFirstIndexInLimit(int lower, int upper) {
        for (int i = 0; i < measurments.length; ++i) {
            if (measurments[i] > lower && measurments[i] < upper) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double minimum = Double.MAX_VALUE;
        for (double one : measurments) {
            if (one < minimum) {
                minimum = one;
            }
        }
        return minimum;
    }

    public double maximum() {
        double maximum = Double.MIN_VALUE;
        for (double one : measurments) {
            if (one > maximum) {
                maximum = one;
            }
        }
        return maximum;
    }

    public ExtremValues minmax() {
        double maximum = Double.MIN_VALUE;
        double minimum = Double.MAX_VALUE;
        for (double one : measurments) {
            if (one > maximum) {
                maximum = one;
            }
            if (one < minimum) {
                minimum = one;
            }
        }
        return new ExtremValues(minimum, maximum);
    }


}
