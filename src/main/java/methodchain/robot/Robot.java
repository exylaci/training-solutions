package methodchain.robot;

import math.RoundingAnomaly;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance;
    private int azimut;
    List<NavigationPoint> navigationPointList = new ArrayList<>();

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public Robot go(int meter) {
        distance += meter;
        return this;
    }

    public Robot rotate(int angle) {
        azimut += angle;
        return this;
    }

    public Robot registerNavigationPoint() {
        navigationPointList.add(new NavigationPoint(distance, azimut));
        return this;
    }

    public List<NavigationPoint> getNavigationList() {
        return navigationPointList;
    }
}
