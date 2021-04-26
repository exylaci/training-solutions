package gyaxi.orokles.airport;

public enum Type {
    PASSENGER(true), PILOT(true), STEWARDESS(true), GROUND_SUPPORT_STAFF(false);

    boolean travel;

    Type(boolean travel) {
        this.travel = travel;
    }

    public boolean isTravel() {
        return travel;
    }
}