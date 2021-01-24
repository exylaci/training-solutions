package timesheet;

public class ReportLine {
    private final Project project;
    private long time;

    public ReportLine(Project project, long time) {
        this.project = project;
        this.time = time;
    }

    public Project getProject() {
        return project;
    }

    public Long getTime() {
        return time;
    }

    public void addTime(int time) {
        this.time += time;
    }
}