package week15.d01;

public class Dates {
    private int buyOn;
    private int saleOn;

    public Dates(int buyOn, int saleOn) {
        this.buyOn = buyOn;
        this.saleOn = saleOn;
    }

    public int getBuyOn() {
        return buyOn;
    }

    public int getSaleOn() {
        return saleOn;
    }

    public void setBuyOn(int buyOn) {
        this.buyOn = buyOn;
    }

    public void setSaleOn(int saleOn) {
        this.saleOn = saleOn;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "buyOn=" + buyOn +
                ", saleOn=" + saleOn +
                '}';
    }
}