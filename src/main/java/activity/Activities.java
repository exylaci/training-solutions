package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    public static final String LIST_NEEDED_ERROR = "Activities list is a must!";
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        if (activities == null) throw new IllegalArgumentException(LIST_NEEDED_ERROR);
        this.activities = new ArrayList<>(activities);
    }

    public int numberOfTrackActivities() {
        int result = 0;
        for (Activity one : activities) {
            if (one.getType().isTracked()) {
                ++result;
            }
        }
        return result;
    }

    public int numberOfWithoutTrackActivities() {
        int result = 0;
        for (Activity one : activities) {
            if (!one.getType().isTracked()) {
                ++result;
            }
        }
        return result;
    }

    public List<Report> distancesByTypes() {
        List<Report> result = new ArrayList<>();
        for (ActivityType one : ActivityType.values()) {
            result.add(new Report(one, summarisingDistancesOf(one)));
        }
        return result;
    }

    private double summarisingDistancesOf(ActivityType activityType) {
        double distance = 0;
        for (Activity one : activities) {
            if (one.getType() == activityType) {
                distance += one.getDistance();
            }
        }
        return distance;
    }
}
//Activities osztály: Activity-k listáját tartalmazza. Le lehet kérdezni a track-es illetve a track nélküli
//listaelemeket. Valamint típusonként külön-külön a távolságot egy Report-okat tartalmazó listába.