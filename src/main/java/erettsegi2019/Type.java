package erettsegi2019;

public enum Type {

    FEB(Fare.FULL_PRICE),
    TAB(Fare.REDUCED_PRICE),
    NYB(Fare.REDUCED_PRICE),
    NYP(Fare.FREE_OF_CHARGE),
    RVS(Fare.FREE_OF_CHARGE),
    GYK(Fare.FREE_OF_CHARGE),
    JGY(Fare.FULL_PRICE);

    private final Fare fare;

    Type(Fare kedvezmeny) {
        this.fare = kedvezmeny;
    }

    public Fare getFare() {
        return fare;
    }
}
