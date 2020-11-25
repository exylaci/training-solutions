package immutable.satellite;

public class CelestialCoordinates {
    private final int x;
    private final int y;
    private final int z;

    public CelestialCoordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("CelestialCoordinates: x=%d, y=%d, z=%d",x ,y , z);
    }
}
