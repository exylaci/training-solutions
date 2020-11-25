package methodchain.robot;

public class NavigationPoint {
    private int distance;
    private int azimut;

    public NavigationPoint(int distance, int azimut) {
        this.distance = distance;
        this.azimut = azimut;
    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    @Override
    public String toString() {
        return String.format("distance: %d azimut: %d", distance, azimut);
    }
}