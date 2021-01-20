package collectionsqueue.job;

public class Job implements Comparable {
    private int priority; // 1 - 10 skálán osztályozzuk a prioritást
    private String jobDescription;
    private boolean urgent; // minden olyan job esetén true, ahol a prioritás < 5

    public Job(int priority, String jobDescription) {
        this.priority = priority;
        this.jobDescription = jobDescription;
        urgent = priority < 5;
    }

    public Job() {
    }

    @Override
    public int compareTo(Object o) {
        if (priority<((Job)o).getPriority()){
            return -1;
        }
        if (priority>((Job)o).getPriority()){
            return 1;
        }
        return 0;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }
}
