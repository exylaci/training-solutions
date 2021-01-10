package activity;

public enum ActivityType {
    BIKING(true), HIKING(true), RUNNING(true), BASKETBALL(false);

    boolean tracked;

    ActivityType(boolean tracked) {
        this.tracked = tracked;
    }

    public boolean isTracked() {
        return tracked;
    }
}
//ActivityType enum: Négy féle típus lehet: BIKING,HIKING,RUNNING,BASKETBALL. Fontos, hogy ebben a sorrendben.