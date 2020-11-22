package introconstructors;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private LocalTime duration;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void start() {
        this.startDateTime = LocalDateTime.now();
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public static void main(String[] args) {
        Task task = new Task("teszt","Teszt megírása");
        System.out.println(
                task.getTitle() + " " +
                task.getDescription() + " " +
                task.getStartDateTime() + " " +
                task.getDuration());

        task.start();
        task.setDuration(LocalTime.of(1,30));
        System.out.println(
                task.getTitle() + " " +
                task.getDescription() + " " +
                task.getStartDateTime() + " " +
                task.getDuration());
    }
}
