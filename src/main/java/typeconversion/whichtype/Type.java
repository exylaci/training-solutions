package typeconversion.whichtype;

public enum Type {
    BYTE,
    SHORT,
    INT;

    private long min;
    private long max;

    public void setMin(long min) {
        this.min = min;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }
}
