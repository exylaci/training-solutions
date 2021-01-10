package activity;

public class Coordinate {
    public static final String INVALID_COORDINATE_ERROR = "This coordinate is out of range!";
    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException(INVALID_COORDINATE_ERROR);
        }

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
//Coordinate immutable osztály: Két adattagja van: a szélességi és hosszúsági fok (latitude,longitude),
// előbbi az értéke [-90,90] intervallumon,
// utóbbi értéke a [-180,180] intervallumon mozoghat.
// Mindkét adattaghoz tartozik egy getter.