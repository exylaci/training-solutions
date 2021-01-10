package activity;

public class ActivityWithoutTrack implements Activity {
    private ActivityType activityType;

    public ActivityWithoutTrack(ActivityType activityType) {
        this.activityType = activityType;
    }

    public ActivityType getType() {
        return activityType;
    }

    public double getDistance() {
        return 0;
    }
}
//ActivityWithoutTrack osztály: Implementálja az Activity interface-t. Mivel itt nincs track adattag, ezért a
// getDistance() mindig nullát ad vissza. A típus hasonló, mint az előző osztályban.