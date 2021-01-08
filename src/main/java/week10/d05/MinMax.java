package week10.d05;

public class MinMax {
    public int min;
    public int max;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void incrementMin(int value) {
        this.min += value;
    }

    public void incrementMax(int value) {
        this.max += value;
    }
}
