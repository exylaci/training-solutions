package erettsegi2019;

public class FreeAndReducedPrice {
    private int free;
    private int reduced;

    public int getFree() {
        return free;
    }

    public void increase(PassangerData passangerData) {
        switch (passangerData.getType().getFare()) {
            case REDUCED_PRICE:
                ++reduced;
                break;
            case FREE_OF_CHARGE:
                ++free;
                break;
        }
    }

    public int getReduced() {
        return reduced;
    }
}
