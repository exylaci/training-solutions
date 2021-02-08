package week15.d01;

public class Dates {
    private int buyOn;
    private int saleOn;

    public int getBuyOn() {
        return buyOn;
    }

    public int getSaleOn() {
        return saleOn;
    }

    public void set(int buyOn, int saleOn) {
        this.buyOn = buyOn;
        this.saleOn = saleOn;
    }

    @Override
    public String toString() {
        return String.format("You should buy on the %dth day, and sale on the %dth day.", buyOn, saleOn);
    }
}