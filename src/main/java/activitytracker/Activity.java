package activitytracker;

import java.time.LocalDateTime;

public class Activity {
    private int id;
    private LocalDateTime startTime;
    private String decription;
    private Type type;

    public Activity(int id, LocalDateTime startTime, String decription, Type type) {
        this(startTime, decription, type);
        this.id = id;
    }

    public Activity(LocalDateTime startTime, String decription, Type type) {
        this.startTime = startTime;
        this.decription = decription;
        this.type = type;
    }

    public Activity(int id, Activity activity) {
        this.id = id;
        this.startTime = activity.startTime;
        this.decription = activity.decription;
        this.type = activity.type;
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
