package timesheet;

import java.util.Map;

public class DataPackedIntoAClass {
    private String fullname;
    private int year;
    private int month;
    private long total;
    private Map<Project, Long> summary;

    public DataPackedIntoAClass(String fullname, int year, int month, long total, Map<Project, Long> summary) {
        this.fullname = fullname;
        this.year = year;
        this.month = month;
        this.total = total;
        this.summary = summary;
    }

    public String getFullname() {
        return fullname;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public long getTotal() {
        return total;
    }

    public Map<Project, Long> getSummary() {
        return summary;
    }
}
