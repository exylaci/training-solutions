package activity;

public class ActivityWithTrack implements Activity {
    private ActivityType activityType;
    private Track track;

    public ActivityWithTrack(Track track, ActivityType activityType) {
        this.activityType = activityType;
        this.track = track;
    }

    @Override
    public double getDistance() {
        return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
//ActivityWithTrack osztály: Implementálja az Activity interface-t. Van egy Track addattagja.
//A getDistance() metódus a megadott track össztávolságát adja vissza míg a getType() a típust.