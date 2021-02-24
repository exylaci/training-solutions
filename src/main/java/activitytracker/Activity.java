package activitytracker;

import java.io.LineNumberInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Activity {
    private int id;
    private LocalDateTime startTime;
    private String decription;
    private Type type;
    private List<TrackPoint> trackPoints;

    public Activity(int id, LocalDateTime startTime, String decription, Type type, List<TrackPoint> trackPoints) {
        this(startTime, decription, type, trackPoints);
        this.id = id;
    }

    public Activity(LocalDateTime startTime, String decription, Type type, List<TrackPoint> trackPoints) {
        this.startTime = startTime;
        this.decription = decription;
        this.type = type;
        this.trackPoints = trackPoints;
    }

    public Activity(int id, Activity activity) {
        this.id = id;
        this.startTime = activity.startTime;
        this.decription = activity.decription;
        this.type = activity.type;
        this.trackPoints = activity.trackPoints;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getDecription() {
        return decription;
    }

    public Type getType() {
        return type;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", decription='" + decription + '\'' +
                ", type=" + type +
                '}';
    }
}
