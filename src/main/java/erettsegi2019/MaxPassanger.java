package erettsegi2019;

public class MaxPassanger {
    private int max=Integer.MIN_VALUE;
    private int stop=-1;

    public void setMax(int max) {
        this.max = max;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public int getMax() {
        return max;
    }

    public int getStop() {
        return stop;
    }
}
