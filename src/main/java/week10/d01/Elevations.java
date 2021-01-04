package week10.d01;

public class Elevations {
    private double up;
    private double down;

    public double getUp() {
        return up;
    }

    public double getDown() {
        return down;
    }

    public void changeAltitude(double newLevel, double previousLevel) {
        up += Math.max(newLevel - previousLevel, 0);
        down += Math.max(previousLevel - newLevel, 0);
    }
}